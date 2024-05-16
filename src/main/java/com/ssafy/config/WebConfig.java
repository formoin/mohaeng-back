package com.ssafy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@MapperScan(basePackages = "com.ssafy.*.model.mapper")
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authInterceptor)
                .addPathPatterns("/**/**")
                .excludePathPatterns("/users/login", "/users/join");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/users/**")
//                .allowedOrigins("http://localhost:5173", "http://172.30.1.39:5173")
//                .allowedMethods("POST");
//        registry.addMapping("/boards/**")
//                .allowedOrigins("http://localhost:5173", "http://172.30.1.39:5173")
//                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
        
        registry.addMapping("/users/**")
        .allowedOrigins("http://localhost:5173", "http://192.168.206.62:5173")
        .allowedMethods("POST");
        registry.addMapping("/boards/**")
        .allowedOrigins("http://localhost:5173", "http://192.168.206.62:5173")
        .allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
    }

}
