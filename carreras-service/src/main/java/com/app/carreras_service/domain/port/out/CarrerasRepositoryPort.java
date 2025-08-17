package com.app.carreras_service.domain.port.out;

import com.app.carreras_service.domain.model.Carrera;

import java.util.List;

public interface CarrerasRepositoryPort {

    public Carrera addCarrera(Carrera carrera);
    public Carrera getCarrea(Long id);
    public List<Carrera> getAllCarreras();
    public Carrera updateCarrera(Carrera carrera);
    public Carrera deleteCarrera(Long id);

}
