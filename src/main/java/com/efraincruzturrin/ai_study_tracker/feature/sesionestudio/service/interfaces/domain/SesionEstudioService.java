package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.service.interfaces.domain;

import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.request.SesionEstudioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.response.SesionEstudioResponseDTO;

import java.util.List;

public interface SesionEstudioService {
    SesionEstudioResponseDTO crear(Long temaId, SesionEstudioRequestDTO dto);
    List<SesionEstudioResponseDTO> listarPorTema(Long temaId);
    SesionEstudioResponseDTO obtener(Long id);
    void eliminar(Long id);
}