package com.app.auth_service.infrastructure.Rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public-key")
@AllArgsConstructor
public class PublicKeyController {

    private KeyPair keyPair;

    @GetMapping("jwks.json")
    public Map<String, Object> getPublicKey(){

        ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();

        // Coordenadas de la clave pública
        String x = Base64.getUrlEncoder().withoutPadding().encodeToString(publicKey.getW().getAffineX().toByteArray());
        String y = Base64.getUrlEncoder().withoutPadding().encodeToString(publicKey.getW().getAffineY().toByteArray());

        Map<String, Object> jwk = new HashMap<>();
        jwk.put("kty", "EC");
        jwk.put("crv", "P-256");
        jwk.put("x", x);
        jwk.put("y", y);
        jwk.put("use", "sig");
        jwk.put("alg", "ES256");
        jwk.put("kid", "auth-key-1");

        Map<String, Object> jwks = new HashMap<>();
        jwks.put("keys", List.of(jwk));

        return jwks;

    }

}
