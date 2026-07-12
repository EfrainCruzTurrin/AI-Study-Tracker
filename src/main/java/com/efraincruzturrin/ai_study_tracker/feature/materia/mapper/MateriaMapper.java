package com.efraincruzturrin.ai_study_tracker.feature.materia.mapper;

import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.request.MateriaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.response.MateriaResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.model.Materia;
import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {
    public Materia toEntity(MateriaRequestDTO dto){
        Materia materia = new Materia();
        materia.setNombre(dto.getNombre());
        materia.setDescripcion(dto.getDescripcion());
        return materia;
    }

    public MateriaResponseDTO toResponseDto(Materia materia) {
        return new MateriaResponseDTO(
                materia.getId(),
                materia.getUsuario().getId(),
                materia.getNombre(),
                materia.getDescripcion()
        );
    }

}
