package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, String>{

	@Query("select c from Cursos c where c.idCurso = :idCurso")
	Cursos findByIdCurso(Long idCurso);
	
}
