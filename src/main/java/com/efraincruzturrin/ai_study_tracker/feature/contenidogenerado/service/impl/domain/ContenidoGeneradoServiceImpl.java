package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.service.impl.domain;

import com.efraincruzturrin.ai_study_tracker.exception.ResourceNotFoundException;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.request.ContenidoGeneradoRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.response.ContenidoGeneradoResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.mapper.ContenidoGeneradoMapper;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.ContenidoGenerado;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.repository.ContenidoGeneradoRepository;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.service.interfaces.domain.ContenidoGeneradoService;
import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import com.efraincruzturrin.ai_study_tracker.feature.tema.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoGeneradoServiceImpl implements ContenidoGeneradoService {

    private final ContenidoGeneradoRepository contenidoGeneradoRepository;
    private final TemaRepository temaRepository;
    private final ContenidoGeneradoMapper contenidoGeneradoMapper;

    public ContenidoGeneradoServiceImpl(ContenidoGeneradoRepository contenidoGeneradoRepository,
                                        TemaRepository temaRepository,
                                        ContenidoGeneradoMapper contenidoGeneradoMapper) {
        this.contenidoGeneradoRepository = contenidoGeneradoRepository;
        this.temaRepository = temaRepository;
        this.contenidoGeneradoMapper = contenidoGeneradoMapper;
    }

    @Override
    public ContenidoGeneradoResponseDTO crear(Long temaId, ContenidoGeneradoRequestDTO dto) {
        Tema tema = temaRepository.findById(temaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tema no encontrado con id: " + temaId));

        ContenidoGenerado contenidoGenerado = contenidoGeneradoMapper.toEntity(dto);
        contenidoGenerado.setTema(tema);

        ContenidoGenerado guardado = contenidoGeneradoRepository.save(contenidoGenerado);
        return contenidoGeneradoMapper.toResponseDto(guardado);
    }

    @Override
    public ContenidoGeneradoResponseDTO obtenerPorId(Long id) {
        ContenidoGenerado contenidoGenerado = contenidoGeneradoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido generado no encontrado con id: " + id));
        return contenidoGeneradoMapper.toResponseDto(contenidoGenerado);
    }

    @Override
    public List<ContenidoGeneradoResponseDTO> listarPorTema(Long temaId) {
        return contenidoGeneradoRepository.findByTemaId(temaId)
                .stream()
                .map(contenidoGeneradoMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<ContenidoGeneradoResponseDTO> listarPorTemaYTipo(Long temaId, Tipo tipo) {
        return contenidoGeneradoRepository.findByTemaIdAndTipo(temaId, tipo)
                .stream()
                .map(contenidoGeneradoMapper::toResponseDto)
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!contenidoGeneradoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contenido generado no encontrado con id: " + id);
        }
        contenidoGeneradoRepository.deleteById(id);
    }
}