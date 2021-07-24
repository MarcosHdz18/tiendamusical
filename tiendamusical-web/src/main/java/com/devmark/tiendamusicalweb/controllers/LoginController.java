/**
 * 
 */
package com.devmark.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.devmark.tiendamusicalentities.entities.Persona;
import com.devmark.tiendamusicalservices.service.LoginService;
import com.devmark.tiendamusicalweb.utils.CommonUtils;

/**
 * @author marcos.hernandez
 * 
 * Controlador que se encarga del flujo de la pantalla de loginTienda.xhmtl.
 *
 */
@ManagedBean
@ViewScoped
public class LoginController {
	
	/**
	 * Usuario capturado por el cliente.
	 */
	private String usuario;
	/**
	 * Contraseña capturada por el cliente.	
	 */
	private String password;
	
	/**
	 * Propiedad de la logica de negocio inyectada con JSF y Spring
	 */
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginServiceImpl;
	
	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	@PostConstruct
	public void init() {
		System.out.println("Inicializando login...");		
	}
	
	/**
	 * Metodo que permite al usuario ingresar a su sesion en la pantalla de home
	 */
	public void iniciarSesion() {
		
		Persona personaLogin = this.loginServiceImpl.consultarUsuarioLogin(this.getUsuario(), this.getPassword());
		
		if (personaLogin != null) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Inicio de Sesión", "¡Su inicio de sesión fue exitoso!");
			try {
				this.redireccionar("home.xhtml");
			} catch (IOException e) {
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "¡Ups! Pagina no encontrada.");
			}
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "¡El usuario y/o contraseña son incorrectos!");
		}
	}
	
	/**
	 * Metodo que redirecciona a una pagina dentro del sistema
	 * @param pagina {@link String} pagina a redireccionar
	 * @throws IOException {@link IOException} Excepcion que se genera si no encuentra la pagina
	 */
	private void redireccionar(String pagina) throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect(pagina);
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
}
