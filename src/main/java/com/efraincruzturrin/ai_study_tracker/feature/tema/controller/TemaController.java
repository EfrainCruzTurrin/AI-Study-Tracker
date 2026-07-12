package com.efraincruzturrin.ai_study_tracker.feature.tema.controller;

import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.request.TemaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.dto.response.TemaResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.tema.service.interfaces.domain.TemaServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temas")
@RequiredArgsConstructor
public class TemaController {

    private final TemaServiceInterface temaService;

    @PostMapping("/materia/{materiaId}")
    public ResponseEntity<TemaResponseDTO> crear(
            @PathVariable Long materiaId,
            @Valid @RequestBody TemaRequestDTO dto) {
        TemaResponseDTO creado = temaService.crear(materiaId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/materia/{materiaId}")
    public ResponseEntity<List<TemaResponseDTO>> listarPorMateria(@PathVariable Long materiaId) {
        return ResponseEntity.ok(temaService.listarPorMateria(materiaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(temaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemaResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody TemaRequestDTO dto) {
        return ResponseEntity.ok(temaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        temaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
