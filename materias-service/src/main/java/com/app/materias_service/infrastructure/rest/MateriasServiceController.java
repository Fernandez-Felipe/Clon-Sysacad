package com.app.materias_service.infrastructure.rest;

import com.app.materias_service.application.service.MateriasService;
import com.app.materias_service.domain.model.Materia;
import com.app.materias_service.domain.model.MateriaId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriasServiceController {

    @Autowired
    MateriasService service;

    @PostMapping("/add")
    public ResponseEntity<Materia> addMateria(@RequestBody Materia materia){

        return ResponseEntity.ok(service.agregarMateria(materia));

    }

    @GetMapping("/get")
    public ResponseEntity<Materia> getMateria(@RequestBody MateriaId id){

        return ResponseEntity.ok(service.obtenerMateria(id));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Materia>> getAllsMaterias(Integer id){

        return ResponseEntity.ok(service.obtenerTodasLasMaterias(id));

    }

}
