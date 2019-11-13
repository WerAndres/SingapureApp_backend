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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="interacciones", schema = "prin")
@JsonInclude(Include.NON_NULL)
public class Interacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_int")
	private Long idInteraccion;

	@Column(name="fecha_act")
	private Date fechaActualizacion;

	@Column(name="fecha_crea")
	private Date fechaCreacion;

	@Column(name="mensaje")
	private String mensaje;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="id_tema")
	private Temas tema;
	
	@Transient
	private String email;

}