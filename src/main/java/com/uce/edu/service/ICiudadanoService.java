package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	
	public void guardar (Ciudadano ciudadano);
	public Ciudadano buscar (Integer id);
	public void actualizar(Ciudadano ciudadano);
	public void eliminar(Integer id);
	
	public Ciudadano buscarCiuPorCedula(String cedula);
	
	public Ciudadano buscarPorCedulaCiud(String cedula);

	public Empleado buscarCPorCedula(String cedula);
	
	public Ciudadano buscarPorApellidoCAQ(String apellido);
	
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
