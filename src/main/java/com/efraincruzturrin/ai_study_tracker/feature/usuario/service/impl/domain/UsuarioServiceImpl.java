package com.efraincruzturrin.ai_study_tracker.feature.usuario.service.impl.domain;

import com.efraincruzturrin.ai_study_tracker.exception.ResourceNotFoundException;
import com.efraincruzturrin.ai_study_tracker.exception.BusinessException;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.dto.request.UsuarioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.dto.response.UsuarioResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.mapper.UsuarioMapper;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.model.Usuario;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.repository.UsuarioRepository;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.service.interfaces.domain.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("Ya existe un usuario con ese email");
        }
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(guardado);
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id " + id));
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponseDTO)
                .toList();
    }

    @Override
    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id " + id));

        // Contraseña en texto PLANO, Corregir
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());

        Usuario actualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con id " + id);
        }
        usuarioRepository.deleteById(id);
    }
}