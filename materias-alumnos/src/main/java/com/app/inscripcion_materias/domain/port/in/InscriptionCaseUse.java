package com.app.inscripcion_materias.domain.port.in;

import com.app.inscripcion_materias.domain.model.Inscripcion;

import java.util.List;

public interface InscriptionCaseUse {

    Inscripcion RealizarInscripcion(Inscripcion ids);
    List<Inscripcion> RevizarInscripciones(Integer legajo);
    Inscripcion EleminarInscripcion(Inscripcion ids);

}
