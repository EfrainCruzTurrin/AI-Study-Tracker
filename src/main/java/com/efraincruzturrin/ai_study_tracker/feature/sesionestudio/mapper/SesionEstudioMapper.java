package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.mapper;

import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.request.SesionEstudioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.response.SesionEstudioResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.model.SesionEstudio;
import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;

public class SesionEstudioMapper {

    public static SesionEstudio toEntity(SesionEstudioRequestDTO dto, Tema tema) {
        return SesionEstudio.builder()
                .tema(tema)
                .duracionMin(dto.getDuracionMin())
                .calificacion(dto.getCalificacion())
                .fecha(java.time.LocalDateTime.now())
                .build();
    }

    public static SesionEstudioResponseDTO toResponseDTO(SesionEstudio entity) {
        Long temaId = (entity.getTema() != null) ? entity.getTema().getId() : null;

        return new SesionEstudioResponseDTO(
                entity.getId(),
                temaId,
                entity.getDuracionMin(),
                entity.getCalificacion(),
                entity.getFecha()
        );
    }
}