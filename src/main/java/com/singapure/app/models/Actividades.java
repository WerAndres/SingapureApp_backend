package com.singapure.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="actividades")
@JsonInclude(Include.NON_NULL)
public class Actividades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_acti")
	private Integer idActi;

	@Column(name="fecha_act")
	private Date fechaAct;

	@Column(name="fecha_crea")
	private Date fechaCrea;

	private String nombre;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="id_tema")
	private Temas tema;

	//bi-directional many-to-one association to TiposActividade
//	@ManyToOne
//	@JoinColumn(name="tipo_acti")
//	private TiposActividades tiposActividades;

}