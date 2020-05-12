package com.yueyang.tt.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

/**
 * @program: IdleStudy
 * @description: jwt
 * @author: qinxiangyang
 * @create: 2020-05-12 15:44
 **/

public class JwtUtils {

    /**
     * 签名的私钥
     */
    @Value("${jwt.config.key}")
    private String key;


    /**
     * 签名的实效时间
     * <p>
     * id:登录用户的id
     * subject：登录用户名
     */
    @Value("${jwt.config.ttl}")
    private long ttl;

    /**
     * 设置认证token
     */
    public String createJwt(String id, String name, Map<String, Object> map) {

        //设置实效时间
        long l = System.currentTimeMillis();
        long exp = l + ttl;
        //创建builder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name).setIssuedAt(new Date()
        ).signWith(SignatureAlgorithm.HS256, key);
        //设置自定义Claim  的map
        jwtBuilder.setClaims(map);
        jwtBuilder.setExpiration(new Date(exp));


        /**
         * token生成
         */
        String token = jwtBuilder.compact();
        return token;
    }


    /**
     * 解析token
     *
     * @param token
     * @return
     */

    public Claims parseJwt(String token) {

        Claims ihrm = Jwts.parser().setSigningKey(key)
                .parseClaimsJws(token).getBody();

        return ihrm;
    }
}