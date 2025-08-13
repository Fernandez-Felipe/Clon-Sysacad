package com.app.exam_service.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inscripciones")
public class ExamenEntity {

    @EmbeddedId
    private ExamenIdEntity id;

    private String estado;

}
