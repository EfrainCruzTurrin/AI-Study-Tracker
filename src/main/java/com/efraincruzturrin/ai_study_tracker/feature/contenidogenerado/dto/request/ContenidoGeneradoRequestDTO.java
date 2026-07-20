package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.request;

import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ContenidoGeneradoRequestDTO {
    @NotNull
    private Tipo tipo;

    @NotBlank
    private String contenido;
}
