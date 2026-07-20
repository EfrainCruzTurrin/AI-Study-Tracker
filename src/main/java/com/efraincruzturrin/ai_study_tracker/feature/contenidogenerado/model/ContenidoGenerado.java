package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model;

import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contenido_generado")

public class ContenidoGenerado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;


    @Column(name = "fecha_generacion", nullable = false)
    private LocalDateTime fechaGeneracion;


    @PrePersist
    protected void prePersist() {
        this.fechaGeneracion = LocalDateTime.now();
    }


}
