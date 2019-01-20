package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwt {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJoaGgiLCJzdWIiOiLlsI_oirEiLCJpYXQiOjE1NDc4NjgyMjB9.gfVseyL2Hlmex6SLWb7r3lPWJHMPBRiscnzisUKdOro";
        String expirToken = "eyJhbGciOiJIUzI1NiJ9" +
                ".eyJqdGkiOiJoaGgiLCJzdWIiOiLlsI_oirEiLCJpYXQiOjE1NDc4NjkzMTIsImV4cCI6MTU0Nzg2OTQzMiwicm9sZSI6ImFkbWluIn0.SsBoJK2VG0E8HOlNzySdaBR8YHyTJmhHJAouBJkBmGA";
        Claims parse = Jwts.parser()
                .setSigningKey("fathua")
                .parseClaimsJws(expirToken)
                .getBody();
        System.out.println("用户ID: " + parse.getId());
        System.out.println("用户名: " + parse.getSubject());
        System.out.println("登录时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parse.getIssuedAt()));
        System.out.println("过期时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parse.getExpiration()));
        System.out.println("用户角色: " + parse.get("role"));
    }
}
