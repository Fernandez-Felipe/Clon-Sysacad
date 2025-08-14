package com.app.materias_service.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "materias")
public class MateriaEntity {

    @EmbeddedId
    MateriaIdEntity id;

    private String nombre;
    private String planDeEstudio;

}
