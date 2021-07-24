/**
 * 
 */
package com.devmark.tiendamusicaldata.dao.impl;

import com.devmark.tiendamusicaldata.common.CommonDAO;
import com.devmark.tiendamusicaldata.dao.PersonaDAO;
import com.devmark.tiendamusicalentities.entities.Persona;

/**
 * @author marcos.hernandez
 * 
 * Clase que implementa el CRUD generico y las funciones de la interface de PersonaDAO
 *
 */
public class PersonaDAOImpl extends CommonDAO<Persona, PersonaDAO> {
	
	/**
	 * Metodo que permite consultar una Persona por su usuario y contraseña	
	 * @param usuario {@link String} usuario capturado por la persona
	 * @param password {@link String} password capturado por la persona
	 * @return {@link Persona} persona encontrada
	 */
	public Persona findByUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}
}
