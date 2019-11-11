package com.singapure.app.models;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="tipos_actividades")
@JsonInclude(Include.NON_NULL)
public class TiposActividades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_act")
	private Integer idTipoAct;

	@Column(name="fecha_act")
	private Timestamp fechaAct;

	@Column(name="fecha_crea")
	private Timestamp fechaCrea;

	@Column(name="nombre")
	private String nombre;

	//bi-directional many-to-one association to Actividade
//	@OneToMany(mappedBy="TiposActividades")
//	private List<Actividades> actividades;

}