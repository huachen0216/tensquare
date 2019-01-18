package com.tensquare.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限。
        // 需要的权限分两部分：
        // 1. 拦截路径
        // 2. 访问改路径需要的权限
        // antMatchers表示拦截什么路径
        // permitAll 任何权限都可以访问，直接放行
        // anyRequest 任何请求
        // authenticated 认证后才能访问
        // .and().csrf().disable() 固定写法，表示使csrf拦截失效

        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
