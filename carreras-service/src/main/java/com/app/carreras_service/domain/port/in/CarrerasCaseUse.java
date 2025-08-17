package com.app.carreras_service.domain.port.in;

import com.app.carreras_service.domain.model.Carrera;

import java.util.List;

public interface CarrerasCaseUse {

    public Carrera agregarCarrera(Carrera carrera);
    public Carrera obtenerCarrea(Long id);
    public List<Carrera> obtenerTodasLasCarreras();
    public Carrera actualizarCarrera(Carrera carrera);
    public Carrera EliminarCarrera(Long id);


}
