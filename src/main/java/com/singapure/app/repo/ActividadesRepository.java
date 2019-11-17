package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Actividades;

@Repository
public interface ActividadesRepository extends JpaRepository<Actividades, String>{

	
	@Query(value = "select * from actividades where id_tema in (\n" + 
			"	select id_tema from temas where id_materia in (\n" + 
			"		select id_materia from usuarios_materias where id_usuario = :idUser group by id_materia\n" + 
			"	) \n" + 
			"	group by id_tema\n" + 
			")\n" + 
			"", nativeQuery = true)
	List<Actividades> findByidUser(@Param("idUser") Long idUser);

	@Query("select a from Actividades a where a.tema.idTema = :idTema")
	List<Actividades> findByidTema(@Param("idTema") Long idTema);
	
}
