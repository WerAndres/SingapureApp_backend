package com.singapure.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="cursos", schema = "prin")
@JsonInclude(Include.NON_NULL)
public class Cursos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_curso")
	private Long idCurso;

	@Column(name="fecha_act")
	private Date fechaActualizacion;

	@Column(name="fecha_crea")
	private Date fechaCreacion;

	@Column(name="nombre")
	private String nombre;

}