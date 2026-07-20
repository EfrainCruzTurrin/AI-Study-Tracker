package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SesionEstudioRequestDTO {

    @Min(0)
    private int duracionMin;

    @Min(0) @Max(5)
    private int calificacion;


}
