package com.app.auth_service.infrastructure.out.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private Integer legajo;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String rol;

}
