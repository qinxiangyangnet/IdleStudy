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

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLlsI_lsI8iLCJpYXQiOjE1ODkyNjkyNzcsImNvbXBhbnlJZCI6IjEyMyIsImNvbXBhbnlOYW1lIjoiaGFoYWgifQ.NNdwotMOwOVXBQ73RDaUDLW5BYQTPRiXYuYjWDAr2d0";

        Claims ihrm = Jwts.parser().setSigningKey("ihrm")
                .parseClaimsJws(token).getBody();


        System.out.println(ihrm.getId());
        ;
        System.out.println(ihrm.getSubject());
        System.out.println(ihrm.getIssuedAt());

        //解析自定义cliam的内容
        String companyId = (String) ihrm.get("companyId");
        String companyName = (String) ihrm.get("companyName");
        System.out.println(companyId+companyName);

    }
}