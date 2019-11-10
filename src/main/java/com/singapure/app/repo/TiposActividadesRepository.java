package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.TiposActividades;

@Repository
public interface TiposActividadesRepository extends JpaRepository<TiposActividades, String>{

}
