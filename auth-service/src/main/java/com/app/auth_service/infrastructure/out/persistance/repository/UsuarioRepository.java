package com.app.auth_service.infrastructure.out.persistance.repository;

import com.app.auth_service.infrastructure.out.persistance.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    Optional<UsuarioEntity> findByLegajo(Integer legajo);
    void deleteByLegajo(Integer legajo);

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioEntity u SET u.nombre = :nombre, u.password = :password WHERE u.id = :id")
    void updateUsuarioById(@Param("nombre")String nombre, @Param("password") String password,
                                              @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioEntity u SET u.nombre = :nombre, u.password = :password WHERE legajo = :legajo")
    void updateUsuarioByLegajo(@Param("nombre")String nombre, @Param("password") String password,
                                              @Param("legajo") Integer legajo);
}
