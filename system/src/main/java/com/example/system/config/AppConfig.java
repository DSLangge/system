package com.example.system.config;

import com.example.system.util.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())    //指定拦截器类
                .addPathPatterns("/**")                 //拦截路径
                .excludePathPatterns("/","/user_login","/verify",
                        "/css/**","/img/**","/js/**",
                        "/layui/**","/static/**");                 //指定排除拦截
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //前方法中写默认访问地址，后方法中写访问首页的逻辑视图名
        registry.addViewController("/").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

    }
}
