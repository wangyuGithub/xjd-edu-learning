package com.xjd.edu.common.component;

import com.xjd.edu.common.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.env.StandardEnvironment;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.xjd.edu.common.constant.HeaderConstant.X_REQUEST_ID;
import static com.xjd.edu.common.constant.HeaderConstant.X_REQUEST_URI;


@Slf4j
public class Slf4jMdcFilter implements Filter {

    final StandardEnvironment environment;

    public Slf4jMdcFilter(StandardEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Slf4jMdcFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws ServletException, IOException {

        final HttpServletRequest req = (HttpServletRequest) request;

        String requestId = req.getHeader(X_REQUEST_ID);
        if (StringUtils.isBlank(requestId)) {
            requestId = "f_" + UuidUtil.uuid();
        }
        MDC.put(X_REQUEST_ID, requestId);

        String upstream = req.getHeader(X_REQUEST_URI);
        if (StringUtils.isBlank(upstream)) {
            upstream = req.getRequestURI();
        }
        MDC.put(X_REQUEST_URI, upstream);

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Slf4jMdcFilter Error", e);
            throw e;
        } finally {
            // 解决串号问题
            MDC.clear();
        }

    }

    /**
     * 构造限流响应
     *
     * @param request
     * @param response
     */
    private void buildLimitResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.warn("CP接口发生限流 uri: {}", request.getRequestURI());
        response.sendError(429, "CP接口发生限流");
    }

    private boolean isCpService() {
        return StringUtils.containsIgnoreCase(environment.getProperty("spring.application.name"), "-cp-");
    }

    @Override
    public void destroy() {
        log.info("Slf4jMdcFilter.destroy()");
    }


}
