package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.service.impl.domain;

import com.efraincruzturrin.ai_study_tracker.exception.ResourceNotFoundException;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.request.SesionEstudioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.response.SesionEstudioResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.mapper.SesionEstudioMapper;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.model.SesionEstudio;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.repository.SesionEstudioRepository;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.service.interfaces.domain.SesionEstudioService;
import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import com.efraincruzturrin.ai_study_tracker.feature.tema.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionEstudioServiceImpl implements SesionEstudioService {

    private final SesionEstudioRepository sesionEstudioRepository;
    private final TemaRepository temaRepository;

    public SesionEstudioServiceImpl(SesionEstudioRepository sesionEstudioRepository,
                                    TemaRepository temaRepository) {
        this.sesionEstudioRepository = sesionEstudioRepository;
        this.temaRepository = temaRepository;
    }

    @Override
    public SesionEstudioResponseDTO crear(Long temaId, SesionEstudioRequestDTO dto) {
        Tema tema = temaRepository.findById(temaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tema no encontrado con id: " + temaId));

        SesionEstudio sesion = SesionEstudioMapper.toEntity(dto, tema);
        SesionEstudio guardada = sesionEstudioRepository.save(sesion);

        return SesionEstudioMapper.toResponseDTO(guardada);
    }

    @Override
    public List<SesionEstudioResponseDTO> listarPorTema(Long temaId) {
        if (!temaRepository.existsById(temaId)) {
            throw new ResourceNotFoundException("Tema no encontrado con id: " + temaId);
        }

        return sesionEstudioRepository.findByTemaId(temaId).stream()
                .map(SesionEstudioMapper::toResponseDTO)
                .toList();
    }

    @Override
    public SesionEstudioResponseDTO obtener(Long id) {
        SesionEstudio sesion = sesionEstudioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sesión de estudio no encontrada con id: " + id));

        return SesionEstudioMapper.toResponseDTO(sesion);
    }

    @Override
    public void eliminar(Long id) {
        if (!sesionEstudioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sesión de estudio no encontrada con id: " + id);
        }
        sesionEstudioRepository.deleteById(id);
    }
}