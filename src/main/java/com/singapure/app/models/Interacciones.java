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
@Table(name="interacciones")
@JsonInclude(Include.NON_NULL)
public class Interacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_int")
	private Integer idInt;

	@Column(name="fecha_act")
	private Timestamp fechaAct;

	@Column(name="fecha_crea")
	private Timestamp fechaCrea;

	@Column(name="nombre")
	private String nombre;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="id_tema")
	private Temas tema;

}