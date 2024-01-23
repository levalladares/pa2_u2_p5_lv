package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro2;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository autorRepository;
	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor);
	}

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.actualizar(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepository.eliminar(id);
	}

	@Override
	public Libro2 seleccionarPA(String nombre) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPA(nombre);
	}

	@Override
	public Autor buscarCriteriaAQ(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarCriteriaAQ(nombre, nacionalidad);
	}

}
