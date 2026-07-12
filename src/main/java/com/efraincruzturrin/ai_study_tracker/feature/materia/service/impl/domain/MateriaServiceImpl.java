package com.efraincruzturrin.ai_study_tracker.feature.materia.service.impl.domain;

import com.efraincruzturrin.ai_study_tracker.exception.ResourceNotFoundException;
import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.request.MateriaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.response.MateriaResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.mapper.MateriaMapper;
import com.efraincruzturrin.ai_study_tracker.feature.materia.model.Materia;
import com.efraincruzturrin.ai_study_tracker.feature.materia.repository.MateriaRepository;
import com.efraincruzturrin.ai_study_tracker.feature.materia.service.interfaces.domain.MateriaService;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.model.Usuario;
import com.efraincruzturrin.ai_study_tracker.feature.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;
    private final UsuarioRepository usuarioRepository;
    private final MateriaMapper materiaMapper;

    @Override
    public MateriaResponseDTO crear(Long usuarioId, MateriaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + usuarioId));

        Materia materia = materiaMapper.toEntity(dto);
        materia.setUsuario(usuario);

        Materia guardada = materiaRepository.save(materia);
        return materiaMapper.toResponseDto(guardada);
    }

    @Override
    public MateriaResponseDTO obtenerPorId(Long id) {
        Materia materia = buscarPorIdOrThrow(id);
        return materiaMapper.toResponseDto(materia);
    }

    @Override
    public List<MateriaResponseDTO> listarPorUsuario(Long usuarioId) {
        return materiaRepository.findByUsuarioId(usuarioId).stream()
                .map(materiaMapper::toResponseDto)
                .toList();
    }

    @Override
    public MateriaResponseDTO actualizar(Long id, MateriaRequestDTO dto) {
        Materia materia = buscarPorIdOrThrow(id);
        materia.setNombre(dto.getNombre());
        materia.setDescripcion(dto.getDescripcion());

        Materia actualizada = materiaRepository.save(materia);
        return materiaMapper.toResponseDto(actualizada);
    }

    @Override
    public void eliminar(Long id) {
        Materia materia = buscarPorIdOrThrow(id);
        materiaRepository.delete(materia);
    }

    private Materia buscarPorIdOrThrow(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada con id: " + id));
    }
}