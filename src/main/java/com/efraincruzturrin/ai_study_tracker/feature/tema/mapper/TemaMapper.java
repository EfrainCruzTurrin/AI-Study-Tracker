package com.efraincruzturrin.ai_study_tracker.feature.tema.mapper;

import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.request.TemaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.response.TemaResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import org.springframework.stereotype.Component;

@Component
public class TemaMapper {
    public Tema toEntity(TemaRequestDTO dto){
        Tema tema = new Tema();
        tema.setNombre(dto.getNombre());
        tema.setDificultad(dto.getDificultad());
        return tema;
    }


    public TemaResponseDTO toResponseDto(Tema tema){
        return new TemaResponseDTO(
                tema.getId(),
                tema.getNombre(),
                tema.getDificultad(),
                tema.getEaseFactor(),
                tema.getIntervalo(),
                tema.getProximoRepaso(),
                tema.getRepeticiones(),
                tema.getMateria() != null ? tema.getMateria().getId() : null
        );
    }

}
