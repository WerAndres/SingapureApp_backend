package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Temas;

@Repository
public interface TemasRepository extends JpaRepository<Temas, String>{
	
	@Query("select t from Temas t where t.idTema = :idTema")
	Temas findByIdtema(@Param("idTema") Long idTema);
	
	@Query(value = "select * from prin.temas where \r\n" + 
			"id_materia in (\r\n" + 
			"	select id_materia from prin.usuarios_materias where id_usuario = :idUser\r\n" + 
			") union all\r\n" + 
			"select * from prin.temas where \r\n" + 
			"id_materia in (\r\n" + 
			"	select id_materia from prin.usuarios_materias where id_usuario in (\r\n" + 
			"		select id_alum from prin.padres_alumnos where id_padre = :idUser\r\n" + 
			"	)\r\n" + 
			")\r\n" + 
			"", nativeQuery = true)
	List<Temas> findByUserIdTemFilter(@Param("idUser") Long idUser);
	

}
