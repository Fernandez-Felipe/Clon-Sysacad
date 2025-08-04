package com.app.auth_service.infrastructure.out.Security;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


public class KeyLoader {

    public static PrivateKey loadPrivateKey(String classpathResource) throws Exception {
        InputStream is = KeyLoader.class.getClassLoader().getResourceAsStream(classpathResource);
        assert is != null;
        String pem = new String(is.readAllBytes(), StandardCharsets.UTF_8)
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        byte[] decoded = Base64.getDecoder().decode(pem);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
        return KeyFactory.getInstance("EC").generatePrivate(keySpec);
    }

    public static PublicKey loadPublicKey(String classpathResource) throws Exception {
        InputStream is = KeyLoader.class.getClassLoader().getResourceAsStream(classpathResource);
        assert is != null;
        String pem = new String(is.readAllBytes(), StandardCharsets.UTF_8)
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] decoded = Base64.getDecoder().decode(pem);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        return KeyFactory.getInstance("EC").generatePublic(keySpec);
    }

}
