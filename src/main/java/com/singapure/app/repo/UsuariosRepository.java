package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

	@Query("SELECT u FROM Usuarios u WHERE u.email = :email and u.password = :pwd")
	Usuarios getUserByEmailAndPwd(@Param("email") String email, @Param("pwd") String pwd);
	
	Usuarios findByEmail(String email);
}
