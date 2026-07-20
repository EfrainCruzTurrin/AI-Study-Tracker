package com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.repository;

import com.efraincruzturrin.ai_study_tracker.feature.sesionestudio.model.SesionEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SesionEstudioRepository extends JpaRepository<SesionEstudio, Long> {

    List<SesionEstudio> findByTemaId(Long temaId);

}
