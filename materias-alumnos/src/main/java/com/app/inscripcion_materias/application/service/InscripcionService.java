package com.app.inscripcion_materias.application.service;

import com.app.inscripcion_materias.domain.model.Inscripcion;
import com.app.inscripcion_materias.domain.port.in.InscriptionCaseUse;
import com.app.inscripcion_materias.domain.port.out.InscriptionRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InscripcionService implements InscriptionCaseUse {

    private final InscriptionRepositoryPort port;

    @Override
    public Inscripcion RealizarInscripcion(Inscripcion ids) {
        return port.RealizeInscription(ids);
    }

    @Override
    public List<Inscripcion> RevizarInscripciones(Integer legajo) {
        return port.CheckInscriptions(legajo);
    }

    @Override
    public Inscripcion EleminarInscripcion(Inscripcion ids) {
        return port.DeleteInscription(ids);
    }
}
