package com.tensquare.qa.interceptor;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huachen
 * @create 2019-01-21 9:25
 */

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response
            , Object handler) {
        System.out.println("经过了拦截器");
        // 拦截器只负责把请求头中包含的token进行解析验证
        String header = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(header)) {
            if (header.startsWith("Bearer ")) {
                // 得到token
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && roles.equals("admin")) {
                        request.setAttribute("claims_admin", token);
                    }
                    if (roles != null && roles.equals("user")) {
                        request.setAttribute("claims_user", token);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("token验证失败");
                }
            }
        }

        return true;
    }
}
