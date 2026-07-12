package com.efraincruzturrin.ai_study_tracker.feature.tema.repository;

import com.efraincruzturrin.ai_study_tracker.feature.tema.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    Optional<Tema> findByNombre(String nombre);
    List<Tema> findByMateriaId(Long materiaId);
    boolean existsByNombreAndMateriaId(String nombre, Long materiaId);
}
