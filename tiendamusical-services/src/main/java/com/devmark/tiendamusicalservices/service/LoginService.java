/**
 * 
 */
package com.devmark.tiendamusicalservices.service;

import com.devmark.tiendamusicalentities.entities.Persona;

/**
 * @author marcos.hernandez
 * 
 * Interface que realiza la logica de negocio para el inicio de sesion de la persona
 *
 */
public interface LoginService {
	
	/**
	 * Metodo que permite consultar un usuario que trata de ingresar a sesion en la tienda musical
	 * @param usuario {@link String} usuario capturado por la persona
	 * @param password {@link String} password capturado por la persona
	 * @return {@link Persona} objeto Persona a consultar desde la base de datos
	 */
	public abstract Persona consultarUsuarioLogin(String usuario, String password);

}
