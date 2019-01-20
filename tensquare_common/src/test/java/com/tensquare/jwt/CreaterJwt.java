package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreaterJwt {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder =
                Jwts.builder()
                        .setId("hhh")
                        .setSubject("小花")
                        .setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "fathua")
                        .setExpiration(new Date(new Date().getTime() + 2000 * 60))
                        .claim("role", "admin");
        System.out.println(jwtBuilder.compact());
    }

}
