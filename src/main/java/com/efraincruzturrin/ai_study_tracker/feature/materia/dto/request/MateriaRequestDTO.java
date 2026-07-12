package com.efraincruzturrin.ai_study_tracker.feature.materia.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(max = 240)
    private String descripcion;
}
