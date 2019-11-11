package com.singapure.app.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="materias", schema = "prin")
@JsonInclude(Include.NON_NULL)
public class Materias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_materia")
	private Integer idMateria;

	@Column(name="fecha_act")
	private Timestamp fechaActualizacion;

	@Column(name="fecha_crea")
	private Timestamp fechaCreacion;

	@Column(name="nombre")
	private String nombre;
	
	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Cursos curso;


	//bi-directional many-to-one association to Tema
	@OneToMany(mappedBy="materia")
	private List<Temas> temas;

}