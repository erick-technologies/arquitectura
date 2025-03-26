package com.bim.sief.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bim.sief.models.User;

public class JwtUtils {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);



    // Expira en 3 horas
    private static final long expirationTime = 3 * 1000 * 60 * 60;

    public static String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getName());
        claims.put("role", user.getRole());
        claims.put("creation",now.getTime());
        claims.put("expired",expiryDate.getTime());



        return Jwts.builder()
                .setSubject(user.getName())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .setClaims(claims)
                .setHeader(header)
                .compact();
    }

    public static String getSubjectFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
