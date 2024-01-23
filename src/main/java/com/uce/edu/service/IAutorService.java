package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro2;

public interface IAutorService {

	public void guardar(Autor autor);

	public Autor buscar(Integer id);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);
	

	public Libro2 seleccionarPA(String nombre);


}
