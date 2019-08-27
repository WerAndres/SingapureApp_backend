package com.singapure.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VIDEO")
public class Video implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVideo;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@ManyToOne
	private Tema tema;

	//Gets and Sets
	public Long getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Long idVideo) {
		this.idVideo = idVideo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
