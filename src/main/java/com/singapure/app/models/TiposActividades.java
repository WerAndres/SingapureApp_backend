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