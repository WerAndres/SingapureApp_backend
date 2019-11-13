package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Interacciones;

@Repository
public interface InteraccionesRepository extends JpaRepository<Interacciones, String>{

	@Query("select i from Interacciones i where i.usuario.idUsuario = :idUsuario")
	List<Interacciones> findByidUser(@Param("idUsuario") Long idUsuario);
	
	@Query("select i from Interacciones i where i.tema.idTema = :idTema")
	List<Interacciones> findByidTema(@Param("idTema") Long idTema);
}
