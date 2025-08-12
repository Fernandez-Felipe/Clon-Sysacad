package com.app.exam_service.infrastructure.rest;

import com.app.exam_service.application.service.ExamenService;
import com.app.exam_service.domain.model.Examen;
import com.app.exam_service.domain.model.Usuario;
import com.app.exam_service.infrastructure.persistance.dtos.IdExamenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Exams")
public class ExamInscriptionController {

    @Autowired
    ExamenService service;

    @GetMapping("/Incriptions")
    public ResponseEntity<List<Examen>> getAllInscriptions(Authentication auth){

        Usuario user = (Usuario) auth.getPrincipal();

        List<Examen> examenes = service.ObtenerTodosLosExamenes(user.getLegajo());

        return ResponseEntity.ok(examenes);

    }

    @PostMapping("/addInscrition")
    public ResponseEntity<Examen> addExam(@RequestBody Examen examen){

        return ResponseEntity.ok(service.AgregarExamen(examen));

    }

    @PutMapping("/UpdateInscription")
    public ResponseEntity<Examen> updateExam(@RequestBody IdExamenRequest request, Authentication auth){

        Usuario user = (Usuario) auth.getPrincipal();

        Examen examen = Examen.builder()
                .id(request.getId())
                .materia_id(request.getId())
                .legajo(user.getLegajo())
                .estado("Inscripto")
                .build();

        return ResponseEntity.ok(service.AgregarExamen(examen));

    }


}
