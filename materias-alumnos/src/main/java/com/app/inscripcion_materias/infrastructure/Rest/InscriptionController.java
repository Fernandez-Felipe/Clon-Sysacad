package com.app.inscripcion_materias.infrastructure.Rest;

import com.app.inscripcion_materias.application.service.InscripcionService;
import com.app.inscripcion_materias.domain.model.Inscripcion;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripciones")
public class InscriptionController {

    InscripcionService inscripcionService;

    @GetMapping("/Bienvenida")
    public String welcome(){
        return "Bienvenido a la seccion Inscripciones!!";
    }

    @PostMapping("/setInscription")
    public Inscripcion RealizeInscription(@RequestBody Long materiaId, Authentication authentication){

        Integer legajo = authentication.get

    }

}
