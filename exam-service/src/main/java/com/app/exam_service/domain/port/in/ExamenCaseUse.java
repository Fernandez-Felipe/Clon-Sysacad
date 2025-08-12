package com.app.exam_service.domain.port.in;

import com.app.exam_service.domain.model.Examen;
import com.app.exam_service.domain.model.IdExamen;

import java.util.List;

public interface ExamenCaseUse {

    public Examen AgregarExamen(Examen examen);
    public Examen ObtenerExamam(IdExamen id);
    public List<Examen> ObtenerTodosLosExamenes(Integer legajo);
    public Examen ActualizarExamen(Examen examen);
    public Examen EliminarExamen(IdExamen id);

}
