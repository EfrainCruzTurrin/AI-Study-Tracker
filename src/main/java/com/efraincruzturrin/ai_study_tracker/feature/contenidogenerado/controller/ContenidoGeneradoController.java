package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.controller;

import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.request.ContenidoGeneradoRequestDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.dto.response.ContenidoGeneradoResponseDTO;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.service.interfaces.domain.ContenidoGeneradoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoGeneradoController {

    private final ContenidoGeneradoService contenidoGeneradoService;

    public ContenidoGeneradoController(ContenidoGeneradoService contenidoGeneradoService) {
        this.contenidoGeneradoService = contenidoGeneradoService;
    }

    @PostMapping("/tema/{temaId}")
    public ResponseEntity<ContenidoGeneradoResponseDTO> crear(
            @PathVariable Long temaId,
            @Valid @RequestBody ContenidoGeneradoRequestDTO dto) {
        ContenidoGeneradoResponseDTO creado = contenidoGeneradoService.crear(temaId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/tema/{temaId}")
    public ResponseEntity<List<ContenidoGeneradoResponseDTO>> listarPorTema(@PathVariable Long temaId) {
        return ResponseEntity.ok(contenidoGeneradoService.listarPorTema(temaId));
    }

    @GetMapping("/tema/{temaId}/tipo/{tipo}")
    public ResponseEntity<List<ContenidoGeneradoResponseDTO>> listarPorTemaYTipo(
            @PathVariable Long temaId,
            @PathVariable Tipo tipo) {
        return ResponseEntity.ok(contenidoGeneradoService.listarPorTemaYTipo(temaId, tipo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoGeneradoResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contenidoGeneradoService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        contenidoGeneradoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}