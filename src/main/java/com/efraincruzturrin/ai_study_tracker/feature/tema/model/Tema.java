package com.efraincruzturrin.ai_study_tracker.feature.tema.model;

import com.efraincruzturrin.ai_study_tracker.feature.materia.model.Materia;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;


    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dificultad dificultad;

    @Column(nullable = false)
    private double easeFactor;

    @Column(nullable = false)
    private int intervalo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date proximoRepaso;

    @Column(nullable = false)
    private int repeticiones;


}
