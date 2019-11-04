package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.TiposUsuarios;

@Repository
public interface TiposUsuariosRepository extends JpaRepository<TiposUsuarios, String> {

}
