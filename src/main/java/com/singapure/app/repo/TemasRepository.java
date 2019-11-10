package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Temas;

@Repository
public interface TemasRepository extends JpaRepository<Temas, String>{

}
