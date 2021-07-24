/**
 * 
 */
package com.devmark.tiendamusicaldata.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author marcos.hernandez
 * 
 * Clase generica que representa los metodos del CRUD que se reutilizan en todas las entidades del proyecto
 * 
 * E-Entidad a utilizar en el CRUD
 * R-Repositorio a utilizar de JPA para ejecutar el CRUD
 *	
 */
public class CommonDAO<E, R extends PagingAndSortingRepository<E, Long>> {
	
	@Autowired
	protected R repository;
	/**
	 * Metodo que permite consultar una lista de objetos paginable de una entidad
	 * @param desde {@link Integer} primer valor de la pagina
	 * @param hasta {@link Integer} ultimo valir de la pagina
	 * @param orderBy {@link String} parametro de ordenamiento
	 * @return {@link List} lista de objetos paginables
	 */
	public List<E> consultarListaPaginable(int desde, int hasta, String orderBy) {
		
		Pageable pageable = PageRequest.of(desde, hasta, Sort.by(orderBy));
		Page<E> page = this.repository.findAll(pageable);
		
		return page.getContent();
	}
	
	/**
	 * Metodo que permite persistir la informacion de cualquier entidad
	 * @param e {@link Object} objeto o entidad a persistir
	 * @return {@link Object} objeto recuperado despues de persistir
	 */
	public E guardar(E e) {
		return this.repository.save(e);
	}
	
	/**
	 * Metodo que permite actualizar la informacion de cualquier entidad
	 * @param e {@link Object} objeto o entidad a actualizar
	 * @return {@link Object} objeto recuperado despues de actualizar
	 */
	public E actualizar(E e) {
		return this.repository.save(e);
	}
	
	/**
	 * Metodo que permite eliminar la informacion de cualquier entidad
	 * @param e {@link Object} objeto o entidad a eliminar
	 */
	public void eliminar(E e) {
		this.repository.delete(e);
	}
}
