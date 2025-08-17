package com.app.carreras_service.application.service;

import com.app.carreras_service.domain.model.Carrera;
import com.app.carreras_service.domain.port.in.CarrerasCaseUse;
import com.app.carreras_service.domain.port.out.CarrerasRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrerasService implements CarrerasCaseUse {

    @Autowired
    CarrerasRepositoryPort port;

    @Override
    public Carrera agregarCarrera(Carrera carrera) {
        return port.addCarrera(carrera);
    }

    @Override
    public Carrera obtenerCarrea(Long id) {
        return port.getCarrea(id);
    }

    @Override
    public List<Carrera> obtenerTodasLasCarreras() {
        return port.getAllCarreras();
    }

    @Override
    public Carrera actualizarCarrera(Carrera carrera) {
        return port.updateCarrera(carrera);
    }

    @Override
    public Carrera EliminarCarrera(Long id) {
        return port.deleteCarrera(id);
    }
}
