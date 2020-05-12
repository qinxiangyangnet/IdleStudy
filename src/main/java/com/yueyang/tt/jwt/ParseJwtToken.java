package com.yueyang.tt.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-12 15:35
 **/
public class ParseJwtToken {

    /**
     * 解析token
     *
     * @param args
     */
    public static void main(String[] args) {

        Claims ihrm = Jwts.parser().setSigningKey("ihrm")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLlsI_lsI8iLCJpYXQiOjE1ODkyNjg4NzJ9.Hva-b_UDatPZqdsLpGnAbTj8dw1tABzKI82fWSs-JW4").getBody();


        System.out.println(ihrm.getId());
        ;
        System.out.println(ihrm.getSubject());
        System.out.println(ihrm.getIssuedAt());

    }
}