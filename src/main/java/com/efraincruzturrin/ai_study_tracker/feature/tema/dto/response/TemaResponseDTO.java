package com.efraincruzturrin.ai_study_tracker.feature.tema.dto.response;

import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Dificultad;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemaResponseDTO {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nombre;

    private Dificultad dificultad;

    private double easeFactor;
    private int intervalo;
    private Date proximoRepaso;
    private int repeticiones;

    private Long materiaId;

}
