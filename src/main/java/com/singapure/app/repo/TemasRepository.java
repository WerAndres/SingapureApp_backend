package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Temas;
import com.singapure.app.models.TiposActividades;

@Repository
public interface TemasRepository extends JpaRepository<Temas, String>{
	
	@Query("select t from Temas t where t.idTema = :idTema")
	Temas findByIdtema(@Param("idTema") Integer idTema);

}
