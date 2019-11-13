package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.PadresAlumnos;

@Repository
public interface PadresAlumnosRepository extends JpaRepository<PadresAlumnos, String>{
	
	@Query("select pa from PadresAlumnos pa where pa.alumno.idUsuario = :idAlumno")
	List<PadresAlumnos> findByIdPadre(@Param("idAlumno") Long idAlumno);
	
	@Query("select pa from PadresAlumnos pa where pa.padre.idUsuario = :idPadre")
	List<PadresAlumnos> findByIdAlumno(@Param("idPadre") Long idPadre);
	
	@Query("select pa from PadresAlumnos pa where pa.padre.idUsuario = :idPadre and pa.alumno.idUsuario = :idAlumno")
	List<PadresAlumnos> findByIdPadreIdAlumno(@Param("idPadre") Long idPadre, @Param("idAlumno") Long idAlumno);

	@Query("select pa from PadresAlumnos pa where pa.idPadreAlumno = :idPadreAlumno")
	PadresAlumnos findByIdPadreAlumno(@Param("idPadreAlumno") Long idPadreAlumno);
	
	@Query(value = "select * from prin.padres_alumnos where id_padre = :idPadre and id_alum in (\r\n" + 
			"	select id_usuario from prin.usuarios_materias where id_materia = :idMateria\r\n" + 
			")", nativeQuery = true)
	List<PadresAlumnos> findMateriasByIdPadre(@Param("idPadre") Long idPadre, @Param("idMateria") Long idMateria);
}
