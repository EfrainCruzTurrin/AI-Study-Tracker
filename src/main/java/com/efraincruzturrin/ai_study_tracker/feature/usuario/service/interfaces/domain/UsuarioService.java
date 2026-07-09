package com.efraincruzturrin.ai_study_tracker.feature.usuario.service.interfaces.domain;

import com.efraincruzturrin.ai_study_tracker.feature.usuario.dto.request.UsuarioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO crear(UsuarioRequestDTO dto);

    UsuarioResponseDTO buscarPorId(Long id);

    List<UsuarioResponseDTO> listarTodos();

    UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto);

    void eliminar(Long id);
}