package com.app.auth_service.infrastructure.adapter.Security.Adapter;

import com.app.auth_service.application.port.out.JwtServicePort;
import com.app.auth_service.infrastructure.adapter.out.DTOS.UserRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtServiceAdapter implements JwtServicePort {

    //esto es recontra provicional, hacer esto es el mundo profesional es una negrada total
    private final SecretKey secretKey = Keys.hmacShaKeyFor("clave-secreta-super-larga-para-jwt-de-256-bits".getBytes());

    @Override
    public String GenerateToken(UserRequest request) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("legajo",request.getLegajo());
        claims.put("role",request.getRol());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(request.getNombre())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000/24))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

    }

}
