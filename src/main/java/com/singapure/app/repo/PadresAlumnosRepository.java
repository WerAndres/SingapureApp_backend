package com.singapure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singapure.app.models.PadresAlumnos;

@Repository
public interface PadresAlumnosRepository extends JpaRepository<PadresAlumnos, String>{

}
