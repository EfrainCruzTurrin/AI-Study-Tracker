package com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.repository;

import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.ContenidoGenerado;
import com.efraincruzturrin.ai_study_tracker.feature.contenidogenerado.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidoGeneradoRepository extends JpaRepository<ContenidoGenerado, Long> {
    List<ContenidoGenerado> findByTemaId(Long temaId);
    List<ContenidoGenerado>findByTemaIdAndTipo(Long temaId, Tipo tipo);

}
