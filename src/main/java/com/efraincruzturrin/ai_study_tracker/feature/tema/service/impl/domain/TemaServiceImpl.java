package com.efraincruzturrin.ai_study_tracker.feature.tema.service.impl.domain;

import com.efraincruzturrin.ai_study_tracker.exception.BusinessException;
import com.efraincruzturrin.ai_study_tracker.exception.ResourceNotFoundException;
import com.efraincruzturrin.ai_study_tracker.feature.materia.model.Materia;
import com.efraincruzturrin.ai_study_tracker.feature.materia.repository.MateriaRepository;
import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.request.TemaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.response.TemaResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.mapper.TemaMapper;
import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import com.efraincruzturrin.ai_study_tracker.feature.tema.repository.TemaRepository;
import com.efraincruzturrin.ai_study_tracker.feature.tema.service.interfaces.domain.TemaServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TemaServiceImpl implements TemaServiceInterface {

    private final TemaRepository temaRepository;
    private final MateriaRepository materiaRepository;
    private final TemaMapper temaMapper;

    @Override
    public TemaResponseDTO crear(Long materiaId, TemaRequestDTO dto) {
        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada con id: " + materiaId));

        if (temaRepository.existsByNombreAndMateriaId(dto.getNombre(), materiaId)) {
            throw new BusinessException("Ya existe un Tema con ese nombre en esta Materia");
        }
        Tema tema = temaMapper.toEntity(dto);
        tema.setMateria(materia);

        // Valores iniciales SM-2 (defaults estándar, sin lógica de repaso)
        tema.setEaseFactor(2.5);
        tema.setIntervalo(0);
        tema.setRepeticiones(0);
        tema.setProximoRepaso(new Date());

        Tema guardado = temaRepository.save(tema);
        return temaMapper.toResponseDto(guardado);
    }

    @Override
    public TemaResponseDTO obtenerPorId(Long id) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tema no encontrado con id: " + id));
        return temaMapper.toResponseDto(tema);
    }

    @Override
    public List<TemaResponseDTO> listarPorMateria(Long materiaId) {
        return temaRepository.findByMateriaId(materiaId)
                .stream()
                .map(temaMapper::toResponseDto)
                .toList();
    }

    @Override
    public TemaResponseDTO actualizar(Long id, TemaRequestDTO dto) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tema no encontrado con id: " + id));

        tema.setNombre(dto.getNombre());
        tema.setDificultad(dto.getDificultad());

        Tema actualizado = temaRepository.save(tema);
        return temaMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!temaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tema no encontrado con id: " + id);
        }
        temaRepository.deleteById(id);
    }
}