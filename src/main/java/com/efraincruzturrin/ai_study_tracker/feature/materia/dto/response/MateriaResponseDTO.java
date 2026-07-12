package com.efraincruzturrin.ai_study_tracker.feature.materia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MateriaResponseDTO {
    private Long id;
    private Long usuarioId;
    private String nombre;
    private String descripcion;
}
