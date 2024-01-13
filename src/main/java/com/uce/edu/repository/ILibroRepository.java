package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {

	public void insertar(Libro libro);
	public Libro seleccionar(Integer id);
	public void actualizar (Libro libro);
	public void eliminar (Integer id);
	
	public void insertar(Libro2 libro2);
	
	public Libro seleccionarPorNombre(String nombre);
	public Libro seleccionarPorTitiloTyped(String titulo);//SIN EL TYPED
	
	public List<Libro> seleccionarPorFechaPublicaion (LocalDate fechaPublicacion);
	public List<Libro> seleccionarPorFechaTyped (LocalDate fechaPublicacion);

	public Libro seleccionarPorTituloNamed(String titulo);
	public List<Libro> seleccionarPorFechaNamed (LocalDate fechaPublicacion);
}
