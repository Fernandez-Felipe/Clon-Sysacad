package com.app.auth_service.infrastructure.out.Security.config;

import com.app.auth_service.infrastructure.out.Security.KeyLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@Configuration
public class KeyPairConfig {

    @Bean
    public KeyPair keyPair() throws Exception {
        PrivateKey priv = KeyLoader.loadPrivateKey("keys/private-key.pem");
        PublicKey pub = KeyLoader.loadPublicKey("keys/public-key.pem");
        return new KeyPair(pub, priv);
    }

}
