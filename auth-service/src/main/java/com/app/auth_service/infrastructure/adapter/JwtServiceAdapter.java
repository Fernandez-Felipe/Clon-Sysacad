package com.app.auth_service.infrastructure.adapter;

import com.app.auth_service.domain.port.out.JwtServicePort;
import com.app.auth_service.infrastructure.adapter.in.DTOS.UserRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtServiceAdapter implements JwtServicePort {

    private final PrivateKey privateKey;

    public JwtServiceAdapter(KeyPair keyPair){
        this.privateKey = keyPair.getPrivate();
    }

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
                .signWith(privateKey, SignatureAlgorithm.ES256)
                .compact();

    }

}
