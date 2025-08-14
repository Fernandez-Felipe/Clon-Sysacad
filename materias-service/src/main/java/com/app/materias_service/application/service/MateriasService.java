package com.app.materias_service.application.service;

import com.app.materias_service.domain.model.Materia;
import com.app.materias_service.domain.model.MateriaId;
import com.app.materias_service.domain.port.in.MateriaCaseUse;
import com.app.materias_service.domain.port.out.MateriaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriasService implements MateriaCaseUse {

    @Autowired
    MateriaRepositoryPort port;

    @Override
    public Materia agregarMateria(Materia materia) {
        return port.addMateria(materia);
    }

    @Override
    public Materia obtenerMateria(MateriaId id) {
        return port.getMateria(id);
    }

    @Override
    public List<Materia> obtenerTodasLasMaterias(Integer carrera_id) {
        return port.getAllMaterias(carrera_id);
    }

    @Override
    public Materia EliminarMateria(MateriaId id) {
        return port.deleteMateria(id);
    }

    @Override
    public Materia actualizarMateria(Materia materia) {
        return port.updateMateria(materia);
    }
}
