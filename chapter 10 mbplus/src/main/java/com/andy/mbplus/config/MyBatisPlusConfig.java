package com.andy.mbplus.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Configuring paging plug-ins
 * @author : Andy
 * @date:   26 Oct 2019
 */
@Configuration
public class MyBatisPlusConfig {
    private  final static Logger logger= LoggerFactory.getLogger(MyBatisPlusConfig.class);

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        logger.debug("Sign up for the paging plug-ins");
        return new PaginationInterceptor();
    }

    /**
     start performance analysis plug-in
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     The primary key strategy
     */
    @Bean
    public IKeyGenerator keyGenerator() {
        return new H2KeyGenerator();
    }

}
