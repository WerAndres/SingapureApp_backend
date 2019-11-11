package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Materias;

@Repository
public interface MateriasRepository extends JpaRepository<Materias, String>{
	
}
