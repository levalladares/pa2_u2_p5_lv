package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro2;

public interface IAutorRepository {
	
	public void insertar (Autor autor);
	public Autor seleccionar (Integer id);
	public void actualizar (Autor autor);
	public void eliminar (Integer id);
	
	public Libro2 seleccionarPA(String nombre);
	
	public Autor seleccionarCriteriaAQ(String nombre, String nacionalidad);

}
