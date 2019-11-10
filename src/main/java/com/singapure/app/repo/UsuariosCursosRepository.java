package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.UsuariosCursos;

@Repository
public interface UsuariosCursosRepository extends JpaRepository<UsuariosCursos, String>{

}
