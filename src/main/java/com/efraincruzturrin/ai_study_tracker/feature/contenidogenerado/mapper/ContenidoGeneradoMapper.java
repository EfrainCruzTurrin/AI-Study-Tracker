package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.mapper;

import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.request.ContenidoGeneradoRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.response.ContenidoGeneradoResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.ContenidoGenerado;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ContenidoGeneradoMapper {
    public ContenidoGenerado toEntity(ContenidoGeneradoRequestDTO dto){
        ContenidoGenerado contenidoGenerado = new ContenidoGenerado();
        contenidoGenerado.setTipo(dto.getTipo());
        contenidoGenerado.setContenido(dto.getContenido());
        return contenidoGenerado;
    }

    public ContenidoGeneradoResponseDTO toResponseDto(ContenidoGenerado contenidoGenerado){
        Long temaId = contenidoGenerado.getTema() != null ? contenidoGenerado.getTema().getId() : null;

        return new ContenidoGeneradoResponseDTO(
                contenidoGenerado.getId(),
                temaId,
                contenidoGenerado.getTipo(),
                contenidoGenerado.getContenido(),
                contenidoGenerado.getFechaGeneracion()
        );
    }
}
