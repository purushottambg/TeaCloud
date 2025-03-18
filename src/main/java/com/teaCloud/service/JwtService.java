package com.teaCloud.service;

import com.teaCloud.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    /*
    Just create and receive data from token
     */

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    private String jwtSecretKey="8963yh43bgfhdjsbcgf73y4rcbsbdbfgcb87cb32huec98db23htr42desnj";

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserEntity user){
        String token = Jwts.builder()
                .subject(user.getMemberID().toString())
                .claim("email", user.getEmail())
                .claim("role", "Student")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(getSecretKey())
                .compact();

        logger.info("Generated token is {}",token);
        return token;
    }

    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Long.valueOf(claims.getSubject());
    }
}
