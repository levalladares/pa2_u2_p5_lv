package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	
	public void insertar (Ciudadano ciudadano);
	public Ciudadano seleccionar (Integer id);
	public void actualizar(Ciudadano ciudadano);
	public void eliminar(Integer id);
	
	public Empleado seleccionarCPorCedula(String cedula);
	public Ciudadano seleccionarPorCedulaCiud(String cedula);
}
