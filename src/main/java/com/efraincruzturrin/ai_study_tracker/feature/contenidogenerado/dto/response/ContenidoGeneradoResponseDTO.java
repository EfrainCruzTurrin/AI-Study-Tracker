package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.response;

import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;
import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ContenidoGeneradoResponseDTO {
    private Long id;
    private Long temaId;
    private Tipo tipo;
    private String contenido;
    private LocalDateTime fechaGeneracion;
}
