/**
 * 
 */
package com.devmark.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmark.tiendamusicaldata.dao.PersonaDAO;
import com.devmark.tiendamusicalentities.entities.Persona;
import com.devmark.tiendamusicalservices.service.LoginService;

/**
 * @author marcos.hernandez
 * 
 * Clase que implementa las funciones para la logica de negocio para la pantalla del login
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private PersonaDAO personaDAOImpl;

	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		return this.personaDAOImpl.findByUsuarioAndPassword(usuario, password);
	}

}
