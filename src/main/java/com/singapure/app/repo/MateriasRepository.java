package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Materias;

@Repository
public interface MateriasRepository extends JpaRepository<Materias, String>{
	
	@Query(value = "select * from prin.materias m where m.id_materia not in (select um.id_materia from prin.usuarios_materias um where um.id_usuario = :idUsuario)", nativeQuery = true)
	List<Materias> findByUserIdMatFilter(@Param("idUsuario") Long idUsuario);
	
	Materias findByIdMateria(Long idMateria);
	
	@Query("select ma from Materias ma where ma.idMateria IN (:listIdMateria)")
	List<Materias> findByManyMatId(@Param("listIdMateria") List<Long> listIdMateria);
}
