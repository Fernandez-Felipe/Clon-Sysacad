package com.app.auth_service.infrastructure.Rest;

import com.app.auth_service.application.service.JwtService;
import com.app.auth_service.application.service.UsuarioService;
import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.infrastructure.out.Security.Dtos.UserLoginRequest;
import com.app.auth_service.infrastructure.out.Security.Dtos.UserLoginResponse;
import com.app.auth_service.infrastructure.out.persistance.DTOS.UserRequest;
import com.app.auth_service.infrastructure.out.persistance.DTOS.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/login")
    public UserLoginResponse GenAuthToken(@RequestBody UserLoginRequest request){

        UserLoginResponse response;

        Usuario usuario = usuarioService.EncontrarUsuarioPorElLegajo(request.getLegajo());

        if(passwordEncoder.matches(request.getPassword(), usuario.getPassword())){
            response = jwtService.GenerarToken(new UserRequest(usuario.getNombre(), usuario.getLegajo(), usuario.getRol()));
        }else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "contraseña incorrecta");

        return response;

    }

    @PostMapping("/register")
    public UserResponse NewUser(@RequestBody Usuario usuario){

        return usuarioService.CrearUsuario(usuario);

    }

    @GetMapping
    public String GetMethod(){
        return "Register page";
    }

}
