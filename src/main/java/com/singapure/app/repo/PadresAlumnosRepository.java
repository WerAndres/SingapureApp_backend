package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.PadresAlumnos;

@Repository
public interface PadresAlumnosRepository extends JpaRepository<PadresAlumnos, String>{
	
	@Query("select pa from PadresAlumnos pa where pa.padre.idUsuario = :idPadre")
	List<PadresAlumnos> findByIdPadre(@Param("idPadre") Long idPadre);
	
	@Query("select pa from PadresAlumnos pa where pa.alumno.idUsuario = :idAlumno")
	List<PadresAlumnos> findByIdAlumno(@Param("idAlumno") Long idAlumno);
	
	@Query("select pa from PadresAlumnos pa where pa.alumno.idUsuario = :idAlumno and pa.padre.idUsuario = :idPadre")
	List<PadresAlumnos> findByIdPadreAlumno(@Param("idPadre") Long idPadre, @Param("idAlumno") Long idAlumno);
}
