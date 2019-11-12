package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.TiposActividades;
import com.singapure.app.models.UsuariosMaterias;

@Repository
public interface TiposActividadesRepository extends JpaRepository<TiposActividades, String>{

	@Query("select tp from TiposActividades tp where tp.idTipoAct = :idTipoAct")
	TiposActividades findByIdAct(@Param("idTipoAct") Integer idTipoAct);

}
