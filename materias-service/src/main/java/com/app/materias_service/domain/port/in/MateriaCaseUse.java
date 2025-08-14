package com.app.materias_service.domain.port.in;

import com.app.materias_service.domain.model.Materia;
import com.app.materias_service.domain.model.MateriaId;

import java.util.List;

public interface MateriaCaseUse {

    public Materia agregarMateria(Materia materia);
    public Materia obtenerMateria(MateriaId id);
    public List<Materia> obtenerTodasLasMaterias(Integer carrera_id);
    public Materia EliminarMateria(MateriaId id);
    public Materia actualizarMateria(Materia materia);

}
