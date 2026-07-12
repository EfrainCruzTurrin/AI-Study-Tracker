package com.efraincruzturrin.ai_study_tracker.feature.materia.repository;

import com.efraincruzturrin.ai_study_tracker.feature.materia.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    Optional<Materia> findByNombre(String nombre);

    List<Materia> findByUsuarioId(Long usuarioId);
}