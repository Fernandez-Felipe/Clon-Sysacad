package com.app.carreras_service.infrastructure.persistance.repository;

import com.app.carreras_service.infrastructure.persistance.entity.CarreraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<CarreraEntity,Long> {
}
