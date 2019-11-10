package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Actividades;

@Repository
public interface ActividadesRepository extends JpaRepository<Actividades, String>{

}
