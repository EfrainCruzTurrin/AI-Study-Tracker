package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.controller;

import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.request.SesionEstudioRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.dto.response.SesionEstudioResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.service.interfaces.domain.SesionEstudioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
public class SesionEstudioController {

    private final SesionEstudioService sesionEstudioService;

    public SesionEstudioController(SesionEstudioService sesionEstudioService) {
        this.sesionEstudioService = sesionEstudioService;
    }

    @PostMapping("/tema/{temaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public SesionEstudioResponseDTO crear(@PathVariable Long temaId,
                                          @Valid @RequestBody SesionEstudioRequestDTO dto) {
        return sesionEstudioService.crear(temaId, dto);
    }

    @GetMapping("/tema/{temaId}")
    public List<SesionEstudioResponseDTO> listarPorTema(@PathVariable Long temaId) {
        return sesionEstudioService.listarPorTema(temaId);
    }

    @GetMapping("/{id}")
    public SesionEstudioResponseDTO obtener(@PathVariable Long id) {
        return sesionEstudioService.obtener(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        sesionEstudioService.eliminar(id);
    }
}