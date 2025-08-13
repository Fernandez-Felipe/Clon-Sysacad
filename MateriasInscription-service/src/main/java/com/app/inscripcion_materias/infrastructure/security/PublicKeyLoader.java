package com.app.inscripcion_materias.infrastructure.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;

@Component
public class PublicKeyLoader {

    private static final String PUBLIC_KEY_URL = "http://sysacad-auth-service:8080/public-key/jwks.json";

    @Getter
    private PublicKey publicKey;

    @PostConstruct
    public void LoadPublicKey() throws ParseException, JOSEException {

        RestTemplate restTemplate = new RestTemplate();
        String jwksJson = restTemplate.getForObject(PUBLIC_KEY_URL, String.class);

        System.out.println("JWKS recibido: " + jwksJson);

        JWKSet jwkSet = JWKSet.parse(jwksJson);

        JWK jwk = jwkSet.getKeys().getFirst();

        if (!(jwk instanceof ECKey ecKey)) {
            throw new IllegalArgumentException("Expected ECKey but got: " + jwk.getClass());
        }

        this.publicKey = ecKey.toECPublicKey();
        System.out.println("Clave pública cargada exitosamente");
    }

}
