package com.efraincruzturrin.ai_study_tracker.feature.materia.service.interfaces.domain;

import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.request.MateriaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.response.MateriaResponseDTO;

import java.util.List;

public interface MateriaService {
    MateriaResponseDTO crear(Long usuarioId, MateriaRequestDTO dto);
    MateriaResponseDTO obtenerPorId(Long id);
    List<MateriaResponseDTO> listarPorUsuario(Long usuarioId);
    MateriaResponseDTO actualizar(Long id, MateriaRequestDTO dto);
    void eliminar(Long id);
}