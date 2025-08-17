package com.app.carreras_service.infrastructure.rest;

import com.app.carreras_service.application.service.CarrerasService;
import com.app.carreras_service.domain.model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarrerasController {

    @Autowired
    CarrerasService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Carrera>> getAll(){

        List<Carrera> carreras = service.obtenerTodasLasCarreras();

        return ResponseEntity.ok(carreras);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getById(@PathVariable Long id ){

        Carrera carrera = service.obtenerCarrea(id);

        return ResponseEntity.ok(carrera);

    }

    @PostMapping("/add")
    public ResponseEntity<Carrera> add(@RequestBody Carrera carrera){

        Carrera newCarrera = service.agregarCarrera(carrera);

        return ResponseEntity.ok(newCarrera);

    }

}