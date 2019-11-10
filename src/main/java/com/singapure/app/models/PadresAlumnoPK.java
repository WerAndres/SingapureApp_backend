package com.singapure.app.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the padres_alumnos database table.
 * 
 */
@Embeddable
public class PadresAlumnoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_alum")
	private Long idAlum;

	@Column(name="id_padre")
	private Long idPadre;

	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PadresAlumnoPK)) {
			return false;
		}
		PadresAlumnoPK castOther = (PadresAlumnoPK)other;
		return 
			this.idAlum.equals(castOther.idAlum)
			&& this.idPadre.equals(castOther.idPadre);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAlum.hashCode();
		hash = hash * prime + this.idPadre.hashCode();
		
		return hash;
	}
}