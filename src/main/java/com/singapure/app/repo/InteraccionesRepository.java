package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Interacciones;

@Repository
public interface InteraccionesRepository extends JpaRepository<Interacciones, String>{

}
