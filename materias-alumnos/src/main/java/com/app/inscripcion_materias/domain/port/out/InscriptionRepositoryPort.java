package com.app.inscripcion_materias.domain.port.out;

import com.app.inscripcion_materias.domain.model.Inscripcion;

import java.util.List;

public interface InscriptionRepositoryPort {

    Inscripcion RealizeInscription(Inscripcion ids);
    List<Inscripcion> CheckInscriptions(Integer legajo);
    Inscripcion DeleteInscription(Inscripcion ids);

}
