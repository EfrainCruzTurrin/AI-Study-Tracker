package com.efraincruzturrin.ai_study_tracker.feature.materia.controller;

import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.request.MateriaRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.dto.response.MateriaResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.materia.service.interfaces.domain.MateriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<MateriaResponseDTO> crear(
            @PathVariable Long usuarioId,
            @Valid @RequestBody MateriaRequestDTO dto) {
        MateriaResponseDTO creada = materiaService.crear(usuarioId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.obtenerPorId(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MateriaResponseDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(materiaService.listarPorUsuario(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MateriaRequestDTO dto) {
        return ResponseEntity.ok(materiaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        materiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}