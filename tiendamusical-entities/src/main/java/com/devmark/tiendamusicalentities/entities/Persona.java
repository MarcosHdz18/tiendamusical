/**
 * 
 */
package com.devmark.tiendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author marcos.hernandez
 * 
 * Entity que mapeara atributos a la tabla persona en la base de datos
 *
 */
@Entity
@Table(name = "persona")
public class Persona extends Common {
	
	/**
	 * Identificador unico de la tabla persona
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona")
	private Long idPersona;
	/**
	 * Numero de identificacion de la persona	
	 */
	@Column(name = "numeroIdentificacion", length = 12, nullable = false)
	private String numeroIdentificacion;
	/**
	 * Nombre de la persona
	 */
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	/**
	 * Apellido paterno de la persona
	 */
	@Column(name = "primerApellido", length = 100, nullable = false)
	private String apellidoPaterno;
	/**
	 * Apellido materno de la persona	
	 */
	@Column(name = "segundoApellido", length = 45)
	private String apellidoMaterno;
	/**
	 * Imagen de la persona
	 */
	@Column(name = "imagen", length = 100)
	private String imagen;
	/**
	 * Tipo de identificacion de la persona
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoIdentificacion")
	@Cascade(CascadeType.ALL)
	private TipoIdentificacion tipoIdentificacion;
	/**
	 * Usuario de la persona
	 */
	@Column(name = "usuario", length = 45, nullable = false)
	private String usuario;
	/**
	 * Password de la persona
	 */
	@Column(name = "password", length = 45, nullable = false)
	private String password;
	/**
	 * Rol de la persona
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol")
	@Cascade(CascadeType.ALL)
	private Rol rol;
	/**
	 * @return the idPersona
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
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

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the tipoIdentificacion
	 */
	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
