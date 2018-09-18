package com.walkBAM;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebConf implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] as={"/walkBAM/login.html","/login.html","/assets/**/**","/static/comp/**/**","/loginMsg.action","/*.action"};
        List<String> patterns=new ArrayList<String>();
        for (String string : as) {
            patterns.add(string);
        }
        // addPathPatterns 配置要拦截的地址
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
