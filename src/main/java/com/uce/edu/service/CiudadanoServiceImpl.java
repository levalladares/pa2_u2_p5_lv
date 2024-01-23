package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public Empleado buscarCPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiud(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedulaCiud(cedula);
	}

	@Override
	public Ciudadano buscarPorApellidoCAQ(String apellido) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorApellidoCAQ(apellido);
	}

	@Override
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarCiuPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiuPorCedula(cedula);
	}

}
