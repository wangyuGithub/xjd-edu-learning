package com.xjd.edu.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.cloud.gateway.config.HttpClientCustomizer;
import org.springframework.cloud.gateway.config.HttpClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.http.client.reactive.ReactorResourceFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.ProxyProvider;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.List;

import static org.springframework.cloud.gateway.config.HttpClientProperties.Pool.PoolType.DISABLED;
import static org.springframework.cloud.gateway.config.HttpClientProperties.Pool.PoolType.FIXED;

@Slf4j
@Configuration
public class ReactNettyConfiguration {
    @Value("${reactor.netty.worker-count}")
    private String workerCount;
    @Value("${reactor.netty.pool.leasingStrategy}")
    private String leasingStrategy;

    @Autowired
    private StandardEnvironment environment;

    @Bean
    public ReactorResourceFactory reactorClientResourceFactory() {
        System.setProperty("reactor.netty.ioWorkerCount", workerCount);
        System.setProperty("reactor.netty.pool.leasingStrategy", leasingStrategy);
        return new ReactorResourceFactory();
    }

    /**
     * 自定义 GatewayHttpClient 主要为了设置 pendingAcquireMaxCount 参数
     *
     * @param properties
     * @param customizers
     * @return
     * @see org.springframework.cloud.gateway.config.GatewayAutoConfiguration.NettyConfiguration#gatewayHttpClient(HttpClientProperties, List)
     */
    @Bean
    public HttpClient gatewayHttpClient(HttpClientProperties properties,
                                        List<HttpClientCustomizer> customizers) {

        // configure pool resources
        HttpClientProperties.Pool pool = properties.getPool();

        ConnectionProvider connectionProvider;
        if (pool.getType() == DISABLED) {
            connectionProvider = ConnectionProvider.newConnection();
        } else if (pool.getType() == FIXED) {
//            connectionProvider = ConnectionProvider.fixed(pool.getName(),
//                    pool.getMaxConnections(), pool.getAcquireTimeout(),
//                    pool.getMaxIdleTime(), pool.getMaxLifeTime());

            connectionProvider = ConnectionProvider.builder(pool.getName())
                    .maxConnections(pool.getMaxConnections())
                    .pendingAcquireMaxCount(environment.getProperty("reactor.netty.pool.pendingAcquireMaxCount", Integer.class, 1000))
                    .pendingAcquireTimeout(Duration.ofMillis(pool.getAcquireTimeout()))
                    .maxIdleTime(pool.getMaxIdleTime())
                    .maxLifeTime(pool.getMaxLifeTime())
                    .build();
        } else {
            /*connectionProvider = ConnectionProvider.elastic(pool.getName(),
                    pool.getMaxIdleTime(), pool.getMaxLifeTime());*/
            connectionProvider =ConnectionProvider.builder(pool.getName())
                    .maxIdleTime(pool.getMaxIdleTime())
                    .maxLifeTime(pool.getMaxLifeTime()).build();
        }

        HttpClient httpClient = HttpClient.create(connectionProvider)
                // TODO: move customizations to HttpClientCustomizers
                .httpResponseDecoder(spec -> {
                    if (properties.getMaxHeaderSize() != null) {
                        // cast to int is ok, since @Max is Integer.MAX_VALUE
                        spec.maxHeaderSize(
                                (int) properties.getMaxHeaderSize().toBytes());
                    }
                    if (properties.getMaxInitialLineLength() != null) {
                        // cast to int is ok, since @Max is Integer.MAX_VALUE
                        spec.maxInitialLineLength(
                                (int) properties.getMaxInitialLineLength().toBytes());
                    }
                    return spec;
                }).tcpConfiguration(tcpClient -> {

                    if (properties.getConnectTimeout() != null) {
                        tcpClient = tcpClient.option(
                                ChannelOption.CONNECT_TIMEOUT_MILLIS,
                                properties.getConnectTimeout());
                    }

                    // configure proxy if proxy host is set.
                    HttpClientProperties.Proxy proxy = properties.getProxy();

                    if (StringUtils.hasText(proxy.getHost())) {

                        tcpClient = tcpClient.proxy(proxySpec -> {
                            ProxyProvider.Builder builder = proxySpec
                                    .type(ProxyProvider.Proxy.HTTP)
                                    .host(proxy.getHost());

                            PropertyMapper map = PropertyMapper.get();

                            map.from(proxy::getPort).whenNonNull().to(builder::port);
                            map.from(proxy::getUsername).whenHasText()
                                    .to(builder::username);
                            map.from(proxy::getPassword).whenHasText()
                                    .to(password -> builder.password(s -> password));
                            map.from(proxy::getNonProxyHostsPattern).whenHasText()
                                    .to(builder::nonProxyHosts);
                        });
                    }
                    return tcpClient;
                });

        HttpClientProperties.Ssl ssl = properties.getSsl();
        if ((ssl.getKeyStore() != null && ssl.getKeyStore().length() > 0)
                || ssl.getTrustedX509CertificatesForTrustManager().length > 0
                || ssl.isUseInsecureTrustManager()) {
            httpClient = httpClient.secure(sslContextSpec -> {
                // configure ssl
                SslContextBuilder sslContextBuilder = SslContextBuilder.forClient();

                X509Certificate[] trustedX509Certificates = ssl
                        .getTrustedX509CertificatesForTrustManager();
                if (trustedX509Certificates.length > 0) {
                    sslContextBuilder = sslContextBuilder
                            .trustManager(trustedX509Certificates);
                } else if (ssl.isUseInsecureTrustManager()) {
                    sslContextBuilder = sslContextBuilder
                            .trustManager(InsecureTrustManagerFactory.INSTANCE);
                }

                try {
                    sslContextBuilder = sslContextBuilder
                            .keyManager(ssl.getKeyManagerFactory());
                } catch (Exception e) {
                    log.error("", e);
                }

                sslContextSpec.sslContext(sslContextBuilder)
                        .defaultConfiguration(ssl.getDefaultConfigurationType())
                        .handshakeTimeout(ssl.getHandshakeTimeout())
                        .closeNotifyFlushTimeout(ssl.getCloseNotifyFlushTimeout())
                        .closeNotifyReadTimeout(ssl.getCloseNotifyReadTimeout());
            });
        }

        if (properties.isWiretap()) {
            httpClient = httpClient.wiretap(true);
        }

        if (!CollectionUtils.isEmpty(customizers)) {
            customizers.sort(AnnotationAwareOrderComparator.INSTANCE);
            for (HttpClientCustomizer customizer : customizers) {
                httpClient = customizer.customize(httpClient);
            }
        }

        return httpClient;
    }


}
