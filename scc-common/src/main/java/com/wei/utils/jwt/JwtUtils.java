package com.wei.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtils {

    private static final long EXPIRE_TIME = 1 * 60 * 1000;

    private static final String CLAIM_NAME = "username";

    public static String createToken(String username, String password) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //加密处理密码
        Algorithm algorithm = Algorithm.HMAC256(password);
        return JWT.create()
                .withClaim(CLAIM_NAME, username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public static JwtStatus verify(String username, String dbPwd, String token) {
        Algorithm algorithm = Algorithm.HMAC256(dbPwd);
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withClaim(CLAIM_NAME, username).build();
        try {
            jwtVerifier.verify(token);
        } catch (TokenExpiredException e){//过期
            return JwtStatus.EXPIRED;
        }catch (JWTVerificationException e) {
            return JwtStatus.ERROR;
        }
        return JwtStatus.SUCCESS;
    }

    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(CLAIM_NAME).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
