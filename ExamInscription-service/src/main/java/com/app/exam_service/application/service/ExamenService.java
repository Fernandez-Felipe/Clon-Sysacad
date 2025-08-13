package com.app.exam_service.application.service;

import com.app.exam_service.domain.model.Examen;
import com.app.exam_service.domain.model.IdExamen;
import com.app.exam_service.domain.port.in.ExamenCaseUse;
import com.app.exam_service.domain.port.out.ExamRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExamenService implements ExamenCaseUse {

    ExamRepositoryPort port;

    @Override
    public Examen AgregarExamen(Examen examen) {
        return port.addExam(examen);
    }

    @Override
    public Examen ObtenerExamam(IdExamen id) {
        return port.getExam(id);
    }

    @Override
    public List<Examen> ObtenerTodosLosExamenes(Integer legajo) {
        return port.getAllExams(legajo);
    }

    @Override
    public Examen ActualizarExamen(Examen examen) {
        return port.UpdateExamen(examen);
    }

    @Override
    public Examen EliminarExamen(IdExamen id) {
        return port.DeleteExam(id);
    }
}
