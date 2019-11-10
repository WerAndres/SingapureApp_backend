package com.singapure.app.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="usuarios_cursos")
@JsonInclude(Include.NON_NULL)
public class UsuariosCursos implements Serializable {
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private UsuariosCursoPK id;

	@Column(name="fecha_act")
	private Timestamp fechaAct;

	@Column(name="fecha_crea")
	private Timestamp fechaCrea;


}