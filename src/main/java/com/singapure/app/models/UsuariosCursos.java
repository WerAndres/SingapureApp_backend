package com.singapure.app.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;


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