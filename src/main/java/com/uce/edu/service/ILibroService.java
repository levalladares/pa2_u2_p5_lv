package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	
	public void guardar(Libro libro);
	public Libro buscar(Integer id);
	public void actualizar (Libro libro);
	public void eliminar (Integer id);
	
	public void guardar(Libro2 libro2);
	public Libro buscarPorNombre(String nombre);
	public List<Libro> buscarPorFechaPublicaion(LocalDate fechaPublicacion);
	public Libro buscarPorTitiloTyped(String titulo);//SIN EL TYPED(nombre)
	public List<Libro> buscarPorFechaTyped (LocalDate fechaPublicacion);//SIN EL TYPED(nombre)
	public Libro buscarPorTituloNamed(String titulo); //SIN EL NAMED
	public List<Libro> buscarPorFechaNamed(LocalDate fechaPublicacion);  //SIN EL NAMED
}
