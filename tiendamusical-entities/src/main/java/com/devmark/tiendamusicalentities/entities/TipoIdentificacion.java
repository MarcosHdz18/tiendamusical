/**
 * 
 */
package com.devmark.tiendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author marcos.hernandez
 * 
 * Entity que mapea atributos a la tabla tipoidentificacion
 * 
 */
@Entity
@Table(name = "tipoidentificacion")
public class TipoIdentificacion extends Common {
	
	/**
	 * Identificador unico de la tabla tipoidentificacion
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoIdentificacion")
	private Long idTipoIdentificacion;
	/**
	 * Nombre del tipo de identificacion
	 */
	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;
	
	/**
	 * @return the idTipoIdentificacion
	 */
	public Long getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}

	/**
	 * @param idTipoIdentificacion the idTipoIdentificacion to set
	 */
	public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
