package com.singapure.app.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="temas", schema = "prin")
@JsonInclude(Include.NON_NULL)
public class Temas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tema")
	private Integer idTema;

	@Column(name="fecha_act")
	private Date fechaAct;

	@Column(name="fecha_crea")
	private Date fechaCrea;

	@Column(name="nombre")
	private String nombre;

	//bi-directional many-to-one association to Actividade
	@OneToMany(mappedBy="tema")
	private List<Actividades> actividades;

	//bi-directional many-to-one association to Interaccione
	@OneToMany(mappedBy="tema")
	private List<Interacciones> interacciones;

//	//bi-directional many-to-one association to Materia
//	@ManyToOne
//	@JoinColumn(name="id_materia")
//	private Materias materia;

}