package com.app.exam_service.domain.port.out;

import com.app.exam_service.domain.model.Examen;
import com.app.exam_service.domain.model.IdExamen;

import java.util.List;

public interface ExamRepositoryPort {

    public Examen addExam(Examen examen);
    public Examen getExam(IdExamen id);
    public List<Examen> getAllExams(Integer legajo);
    public Examen UpdateExamen(Examen examen);
    public Examen DeleteExam(IdExamen ID);

}
