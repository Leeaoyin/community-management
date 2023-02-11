package org.management.core.infrastructure.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.management.core.domain.event.Const;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.management.core.domain.event.Const.EMPTY;

@Slf4j
@Component
public class TokenUtils {

    /**
     * 默认 token 超时时间
     */
    @Value("${jwtToken.timeout:1800000}")
    private Long TIMEOUT;

    /**
     * 默认 jwt 生成算法
     */
    @Value("${jwtToken.algorithm:HS512}")
    private String ALGORITHM;
    @Value("${jwtToken.secret:Pa@ss@Word}")
    private String TOKEN_SECRET;

    private static final int PASSWORD_LEN = 8;

    private static final char[] PASSWORD_SEEDS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static String randomPassword() {
        IntStream intStream = new Random().ints(0, PASSWORD_SEEDS.length);
        return intStream.limit(PASSWORD_LEN).mapToObj(i -> PASSWORD_SEEDS[i]).map(String::valueOf).collect(Collectors.joining());
    }


    /**
     * 根据用户名密码生成token
     * @param username
     * @param password
     * @return
     */
    public String generateToken(String username, String password) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(Const.TOKEN_USER_NAME, StringUtils.isEmpty(username) ? EMPTY : username);
        claims.put(Const.TOKEN_USER_PASSWORD, StringUtils.isEmpty(password) ? EMPTY : password);
        claims.put(Const.TOKEN_CREATE_TIME, System.currentTimeMillis());
        return generate(claims);
    }

    private String generate(Map<String, Object> claims) {
        return toTokenString(TIMEOUT, claims);
    }

    private String toTokenString(Long timeOutMillis, Map<String, Object> claims) {
        Long expiration = Long.parseLong(claims.get(Const.TOKEN_CREATE_TIME) + EMPTY) + timeOutMillis;

        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(claims.get(Const.TOKEN_USER_NAME).toString())
                    .setExpiration(new Date(expiration))
                    .signWith(null != SignatureAlgorithm.valueOf(ALGORITHM) ?
                            SignatureAlgorithm.valueOf(ALGORITHM) :
                            SignatureAlgorithm.HS512, TOKEN_SECRET.getBytes("UTF-8"))
                    .compact();
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(claims.get(Const.TOKEN_USER_NAME).toString())
                    .setExpiration(new Date(expiration))
                    .signWith(null != SignatureAlgorithm.valueOf(ALGORITHM) ?
                            SignatureAlgorithm.valueOf(ALGORITHM) :
                            SignatureAlgorithm.HS512, TOKEN_SECRET)
                    .compact();
        }
    }
    /**
     * 解析 token 用户名
     *
     * @param token
     * @return
     */
    public String getUsername(String token) {
        String username = null;
        try {
            final Claims claims = getClaims(token);
            username = claims.get(Const.TOKEN_USER_NAME).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    /**
     * 解析 token 密码
     *
     * @param token
     * @return
     */
    public String getPassword(String token) {
        String password = null;
        try {
            final Claims claims = getClaims(token);
            password = claims.get(Const.TOKEN_USER_PASSWORD).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    /**
     * 获取token claims
     *
     * @param token
     * @return
     */
    private Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET.getBytes("UTF-8"))
                    .parseClaimsJws(token.trim())
                    .getBody();
        } catch (Exception e) {
            claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token.trim())
                    .getBody();
        }
        return claims;
    }

    /**
     * 获取永久token
     * @param username
     * @param password
     * @return
     */
    public String generateContinuousToken(String username, String password) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(Const.TOKEN_USER_NAME, StringUtils.isEmpty(username) ? EMPTY : username);
        claims.put(Const.TOKEN_USER_PASSWORD, StringUtils.isEmpty(password) ? EMPTY : password);
        claims.put(Const.TOKEN_CREATE_TIME, System.currentTimeMillis());
        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(claims.get(Const.TOKEN_USER_NAME).toString())
                    .signWith(null != SignatureAlgorithm.valueOf(ALGORITHM) ?
                            SignatureAlgorithm.valueOf(ALGORITHM) :
                            SignatureAlgorithm.HS512, TOKEN_SECRET.getBytes("UTF-8"))
                    .compact();
        } catch (UnsupportedEncodingException ex) {
            log.warn(ex.getMessage());
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(claims.get(Const.TOKEN_USER_NAME).toString())
                    .signWith(null != SignatureAlgorithm.valueOf(ALGORITHM) ?
                            SignatureAlgorithm.valueOf(ALGORITHM) :
                            SignatureAlgorithm.HS512, TOKEN_SECRET)
                    .compact();
        }
    }

    /**
     * 获取 token 超时时间
     *
     * @param token
     * @return
     */
    public Date getExpirationDate(String token) {
        Date expiration = null;
        try {
            final Claims claims = getClaims(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expiration;
    }

    /**
     * token 是否超时
     *
     * @param token
     * @return
     */
    public Boolean isExpired(String token) {
        final Date expiration = getExpirationDate(token);
        //超时时间为空则永久有效
        return null == expiration ? false : expiration.before(new Date(System.currentTimeMillis()));
    }
}
