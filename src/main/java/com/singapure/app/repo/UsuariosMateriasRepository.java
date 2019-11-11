package com.singapure.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.UsuariosMaterias;

@Repository
public interface UsuariosMateriasRepository extends JpaRepository<UsuariosMaterias, String>{
	
	@Query("select uc from UsuariosMaterias uc where uc.usuario.idUsuario = :idUsuario")
	List<UsuariosMaterias> findByUserId(@Param("idUsuario") Long idUsuario);
	
	@Query("select uc from UsuariosMaterias uc where uc.usuario.idUsuario = :idUsuario and uc.materia.idMateria = :idMateria")
	List<UsuariosMaterias> findByUserIdMat(@Param("idUsuario") Long idUsuario, @Param("idMateria") Long idMateria);

	@Query("select uc from UsuariosMaterias uc where uc.idUsuarioMateria = :idUsuarioMateria")
	UsuariosMaterias findByIdUserIdMat(@Param("idUsuarioMateria") Long idUsuarioMateria);

}
