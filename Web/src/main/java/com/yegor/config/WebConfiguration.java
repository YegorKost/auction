package com.yegor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by YegorKost on 14.05.2017.
 */
@Configuration
@ComponentScan(value = "com.yegor.controller")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/auctions/**").addResourceLocations("/auctions/");
    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry
//                .jsp("/auction/", ".jsp")
//                .viewClass(JstlView.class);
//
//    }

    @Bean
    public InternalResourceViewResolver setUpViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/auctions/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

}
