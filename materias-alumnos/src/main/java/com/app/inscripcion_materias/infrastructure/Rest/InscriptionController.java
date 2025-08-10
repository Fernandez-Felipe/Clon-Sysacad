package com.app.inscripcion_materias.infrastructure.Rest;

import com.app.inscripcion_materias.application.service.InscripcionService;
import com.app.inscripcion_materias.domain.model.Inscripcion;
import com.app.inscripcion_materias.domain.model.Usuario;
import com.app.inscripcion_materias.infrastructure.out.Dtos.InscriptionRequest;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionEntity;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionIds;
import com.app.inscripcion_materias.infrastructure.out.persistance.Mapper.InscriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscriptionController {

    @Autowired
    InscripcionService inscripcionService;

    @Autowired
    InscriptionMapper inscriptionMapper;

    @GetMapping("/Bienvenida")
    public String welcome(){
        return "Bienvenido a la seccion Inscripciones!!";
    }

    @PostMapping("/setInscription")
    public Inscripcion RealizeInscription(@RequestBody InscriptionRequest id, Authentication auth){

        Usuario usuario = (Usuario) auth.getPrincipal();

        InscriptionIds ids = InscriptionIds.builder().materiaid(id.getMateriaid()).legajo(usuario.getLegajo()).build();
        InscriptionEntity inscription = InscriptionEntity.builder().id(ids).estado("Inscripto").build();

        return inscripcionService.RealizarInscripcion(inscriptionMapper.mapToInscripcion(inscription));

    }

    @GetMapping("/getInscriptions")
    public ResponseEntity<List<Inscripcion>> getAllInscriptions(Authentication auth){

        Usuario user = (Usuario) auth.getPrincipal();

        Integer legajo = user.getLegajo();

        List<Inscripcion> inscripciones = inscripcionService.RevizarInscripciones(legajo);

        return ResponseEntity.ok(inscripciones);

    }

    @DeleteMapping("/deleteInscription")
    public ResponseEntity<Inscripcion> deleteInscription(@RequestBody InscriptionRequest id, Authentication auth){

        Usuario user = (Usuario)auth.getPrincipal();
        Integer legajo = user.getLegajo();

        InscriptionIds ids = InscriptionIds.builder().legajo(legajo).materiaid(id.getMateriaid()).build();

        Inscripcion deletedInscription = inscripcionService.EleminarInscripcion(ids);

        return ResponseEntity.ok(deletedInscription);

    }


}
