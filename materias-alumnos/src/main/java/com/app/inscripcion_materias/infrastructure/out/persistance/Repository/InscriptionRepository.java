package com.app.inscripcion_materias.infrastructure.out.persistance.Repository;

import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionEntity;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionIds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, InscriptionIds> {

    List<InscriptionEntity> findAllById_Legajo(Integer Legajo);

}
