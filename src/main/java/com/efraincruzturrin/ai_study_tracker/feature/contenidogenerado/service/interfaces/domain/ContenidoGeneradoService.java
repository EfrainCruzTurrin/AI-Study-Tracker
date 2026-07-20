package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.service.interfaces.domain;

import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.request.ContenidoGeneradoRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.response.ContenidoGeneradoResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;

import java.util.List;

public interface ContenidoGeneradoService {
    ContenidoGeneradoResponseDTO crear(Long temaId, ContenidoGeneradoRequestDTO dto);
    ContenidoGeneradoResponseDTO obtenerPorId(Long id);
    List<ContenidoGeneradoResponseDTO> listarPorTema(Long temaId);
    List<ContenidoGeneradoResponseDTO> listarPorTemaYTipo(Long temaId, Tipo tipo);
    void eliminar(Long id);
}
