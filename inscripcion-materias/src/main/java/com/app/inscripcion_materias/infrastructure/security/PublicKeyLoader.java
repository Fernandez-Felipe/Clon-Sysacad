package com.app.inscripcion_materias.infrastructure.security;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class PublicKeyLoader {

    private static final String PUBLIC_KEY_URL = "http://auth-service:8080/public-key";

    @Getter
    private PublicKey publicKey;

    @PostConstruct
    public void LoadPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {

        RestTemplate restTemplate = new RestTemplate();
        String pem = restTemplate.getForObject(PUBLIC_KEY_URL, String.class);

        // 2. Eliminar encabezado y pie del PEM
        String pemClean = pem
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", "");

        // 3. Decodificar base64
        byte[] keyBytes = Base64.getDecoder().decode(pemClean);

        // 4. Crear PublicKey desde los bytes
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("EC"); // ES256 usa algoritmo EC
        this.publicKey = kf.generatePublic(spec);

    }

}
