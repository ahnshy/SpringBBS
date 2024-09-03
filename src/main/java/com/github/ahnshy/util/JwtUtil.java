package com.github.ahnshy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    String secret;

    public String createToken(String userId, String userName) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        Date setTimeBombs = new Date(timeInSecs + (30 * 60 * 1000));   // Set 30 minutes

        return JWT.create()
                .withIssuer("vue-board")
                .withClaim("userId", userId)
                .withClaim("userName", userName)
                .withExpiresAt(setTimeBombs)
                .withIssuedAt(date.getTime())
                .sign(algorithm);
    }

    public DecodedJWT decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("vue-board")
                    .build();
            return verifier.verify(token);

        } catch (JWTVerificationException e) {
            log.error("JWTVerificationException: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return null;
    }
}
