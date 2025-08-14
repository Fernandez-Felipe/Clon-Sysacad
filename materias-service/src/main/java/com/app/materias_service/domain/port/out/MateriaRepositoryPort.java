package com.app.materias_service.domain.port.out;

import com.app.materias_service.domain.model.Materia;
import com.app.materias_service.domain.model.MateriaId;

import java.util.List;

public interface MateriaRepositoryPort {

    public Materia addMateria(Materia materia);
    public Materia getMateria(MateriaId id);
    public List<Materia> getAllMaterias(Integer carrera_id);
    public Materia deleteMateria(MateriaId id);
    public Materia updateMateria(Materia materia);

}
