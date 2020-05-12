package com.yueyang.tt.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-12 15:29
 **/
public class CreatJwtTest {

    /**
     * 同过jwt验证token
     *
     * @param args
     */
    public static void main(String[] args) {


        /**
         * token生成
         */
        JwtBuilder jwtBuilder = Jwts.builder().setId("111").setSubject("小小").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "ihrm");
        String token = jwtBuilder.compact();
        System.out.println(token);


    }
}