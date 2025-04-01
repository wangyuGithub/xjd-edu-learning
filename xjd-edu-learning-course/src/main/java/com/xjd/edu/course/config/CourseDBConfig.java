package com.xjd.edu.course.config;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageHelper;
import com.xjd.edu.conf.EnableCourseDataSource;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableCourseDataSource
// 扫描从数据源对应的Mapper接口所在包，指定sqlSessionFactory的引用名称
@MapperScan(basePackages = "com.xjd.edu.course.dao.course", sqlSessionFactoryRef = "courseSqlSessionFactory")
public class CourseDBConfig {

    // 配置从数据源对应的SqlSessionFactory
    @Bean(name = "courseSqlSessionFactory")
    public SqlSessionFactory courseSqlSessionFactory(@Qualifier("courseDataSource") DataSource dataSource, MeterRegistry registry) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        // false: pageNum<1和大于总页数时，返回空;true: pageNum<1返回第一页，大于总页数返回最后一页
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);

        // 添加插件，执行顺序与添加顺序相反
        //bean.setPlugins(new Interceptor[]{new CheckQueryLimitInterceptor(registry), pageHelper});

        List<Resource> resources = new ArrayList<Resource>();
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        resources.addAll(Arrays.asList(pathMatchingResourcePatternResolver.getResources("classpath:/mapper/course/*.xml")));
        resources.addAll(Arrays.asList(pathMatchingResourcePatternResolver.getResources("classpath:/mapper/course/**/*.xml")));
        bean.setMapperLocations(ArrayUtil.toArray(resources, Resource.class));
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

    // 配置从数据源对应的事务管理器
    @Bean(name = "courseTransactionManager")
    public DataSourceTransactionManager courseTransactionManager(@Qualifier("courseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 配置从数据源对应的SqlSessionTemplate
    @Bean(name = "courseSqlSessionTemplate")
    public SqlSessionTemplate courseSqlSessionTemplate(@Qualifier("courseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}