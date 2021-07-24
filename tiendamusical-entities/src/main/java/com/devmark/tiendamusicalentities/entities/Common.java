/**
 * 
 */
package com.devmark.tiendamusicalentities.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author marcos.hernandez
 * 
 * Clase que permite heredar atributos comunes a otras clases
 *
 */
@MappedSuperclass
public class Common {
	
	/**
	 * Fecha de creacion de la persona
	 */
	@Column(name = "fechaCreacion", nullable = false)
	private LocalDateTime fechaCreacion;
	/**
	 * Fecha de modificacion de la persona
	 */
	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;
	/**
	 * Estatus de la persona
	 */
	@Column(name = "estatus")
	private boolean estatus;
	
	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
}
