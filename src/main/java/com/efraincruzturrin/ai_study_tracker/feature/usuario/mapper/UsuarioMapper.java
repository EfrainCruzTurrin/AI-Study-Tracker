package com.efraincruzturrin.ai_study_tracker.feature.usuario.mapper;

import com.efraincruzturrin.ai_study_tracker.feature.usuario.dto.request.UsuarioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.dto.response.UsuarioResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getFechaRegistro()
        );
    }
}