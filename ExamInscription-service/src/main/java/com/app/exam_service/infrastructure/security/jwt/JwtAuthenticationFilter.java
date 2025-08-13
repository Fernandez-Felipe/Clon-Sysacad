package com.app.exam_service.infrastructure.security.jwt;

import com.app.exam_service.domain.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


@Slf4j
@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final PublicKeyLoader keyLoader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            try {
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(keyLoader.getPublicKey())
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String name = claims.getSubject();
                Integer legajo = claims.get("legajo", Integer.class);
                String role = claims.get("role", String.class);

                Usuario user = Usuario.builder().nombre(name).legajo(legajo).rol(role).build();

                List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception ex) {

                request.setAttribute("Exception", ex);
                request.getRequestDispatcher("/error/AuthError").forward(request,response);

                return;
            }
        } else {
            request.setAttribute("Header", authHeader);
            request.getRequestDispatcher("/error/jwt").forward(request,response);
            return;
        }



        filterChain.doFilter(request, response);

    }
}

