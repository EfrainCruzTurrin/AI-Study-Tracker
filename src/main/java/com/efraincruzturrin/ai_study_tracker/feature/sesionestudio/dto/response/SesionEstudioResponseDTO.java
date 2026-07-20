package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.response;

import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

public class SesionEstudioResponseDTO {
    private Long id;
    private Long temaId;
    private int duracionMin;
    private int calificacion;
    private LocalDateTime fecha;
}
