package com.app.carreras_service.infrastructure.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @PostMapping("/jwt")
    public ResponseEntity<String> handleJwtError(HttpServletRequest request) {
        // Recupero lo que mandaste en el filtro
        String authHeader = (String) request.getAttribute("Header");

        // Podés armar la respuesta como quieras
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("JWT inválido o expirado. Header recibido: " + authHeader);
    }

    @GetMapping("/AuthError")
    public ResponseEntity<Map<String, Object>> handleAuthError(HttpServletRequest request) {
        Exception ex = (Exception) request.getAttribute("Exception");

        Map<String, Object> body = new HashMap<>();
        body.put("error", "Error al validar el token");
        body.put("message", ex != null ? ex.getMessage() : "Token inválido o expirado");

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED) // 401
                .body(body);
    }

}
