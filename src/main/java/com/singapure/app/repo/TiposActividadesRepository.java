package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.TiposActividades;

@Repository
public interface TiposActividadesRepository extends JpaRepository<TiposActividades, String>{

	@Query("select tp from TiposActividades tp where tp.idTipoActividad = :idTipoActividad")
	TiposActividades findByIdAct(@Param("idTipoActividad") Long idTipoActividad);

}
