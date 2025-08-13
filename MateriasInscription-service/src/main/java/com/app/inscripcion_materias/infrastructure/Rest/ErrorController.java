package com.app.inscripcion_materias.infrastructure.Rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/jwt")
    public String JwtError(HttpServletRequest request){

        String header = request.getAttribute("Header").toString();

        return "No se procesa de manera correcta el token Jwt. el header recivido fue: "+header;
    }

    @GetMapping("/AuthError")
    public String PublicKeyError(HttpServletRequest request){

        String ex = request.getAttribute("Exception").toString();

        return ex;
    }

    @GetMapping
    public String DefaultError(){
        return "Ocurrio un error";
    }

}
