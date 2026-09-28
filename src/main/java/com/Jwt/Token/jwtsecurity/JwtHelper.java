package com.Jwt.Token.jwtsecurity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
@Component
public class JwtHelper {

    private static final String SECRET =
            "mySecretKeyForJwtAuthenticationMustBeLongEnough123456";

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 30)
                )
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromToken(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public static boolean validateToken(String token, UserDetails username) {

        try {
            String tokenUsername = getUsernameFromToken(token);

            return tokenUsername.equals(username)
                    && !isTokenExpired(token);

        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isTokenExpired(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getExpiration().before(new Date());
    }
}