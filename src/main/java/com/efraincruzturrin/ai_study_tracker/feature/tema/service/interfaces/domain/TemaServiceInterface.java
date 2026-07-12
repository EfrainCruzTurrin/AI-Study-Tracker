package com.efraincruzturrin.ai_study_tracker.feature.tema.service.interfaces.domain;

import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.request.TemaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.response.TemaResponseDTO;

import java.util.List;

public interface TemaServiceInterface {
    TemaResponseDTO crear(Long materiaId, TemaRequestDTO dto);
    TemaResponseDTO obtenerPorId(Long id);
    List<TemaResponseDTO> listarPorMateria(Long materiaId);
    TemaResponseDTO actualizar(Long id, TemaRequestDTO dto);
    void eliminar(Long id);
}