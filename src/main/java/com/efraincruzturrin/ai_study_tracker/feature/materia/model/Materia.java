package com.efraincruzturrin.ai_study_tracker.feature.materia.model;

import com.efraincruzturrin.ai_study_tracker.feature.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "materia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 240)
    private String descripcion;


}