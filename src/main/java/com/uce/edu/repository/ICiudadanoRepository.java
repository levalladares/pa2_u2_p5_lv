package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public void insertar(Ciudadano ciudadano);

	public Ciudadano seleccionar(Integer id);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	public Empleado seleccionarCPorCedula(String cedula);

	public Ciudadano seleccionarPorCedulaCiud(String cedula);

	public Ciudadano seleccionarCiuPorCedula(String cedula);

	public Ciudadano seleccionarPorApellidoCAQ(String apellido);

	// funcionalidad que cuando sea el ciudadano de Pichincha lo busque por nombre
	// cuando sea de Cotopaxi lo busque por apellido
	// y cuando no sea de ninguna de las dos lo busque por cedula
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
	
	
	
}
