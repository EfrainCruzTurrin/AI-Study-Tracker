package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.model;

import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "sesion_estudio")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SesionEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;

    @Column(nullable = false)
    private int duracionMin;

    @Column (nullable = false)
    private int calificacion;

    @Column(nullable = false)
    private LocalDateTime fecha;
}
