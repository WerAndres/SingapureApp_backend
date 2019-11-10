package com.singapure.app.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@Entity
@Table(name="padres_alumnos")
@JsonInclude(Include.NON_NULL)
public class PadresAlumnos implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PadresAlumnoPK id;
	
	@Column(name="fecha_act")
	private Timestamp fechaAct;

	@Column(name="fecha_crea")
	private Timestamp fechaCrea;

}