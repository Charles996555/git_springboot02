package com.woniu.springboot02.config;

import com.woniu.springboot02.component.LoginHandlerInterceptor;
import com.woniu.springboot02.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login","/index","/","/asserts/**","/user/login");
    }

    //静态文件
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //静态文件
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        //webjar文件
//        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
//    }



    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/").setViewName("login");

            }
        };
        return webMvcConfigurer;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }



}
