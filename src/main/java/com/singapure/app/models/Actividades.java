package com.singapure.app.models;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;



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
	private Timestamp fechaAct;

	@Column(name="fecha_crea")
	private Timestamp fechaCrea;

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