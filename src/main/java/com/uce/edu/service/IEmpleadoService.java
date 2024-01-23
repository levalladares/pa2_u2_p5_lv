package com.uce.edu.service;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
	
	public Empleado buscar(Integer id);
	public void guardar (Empleado empleado);
	public void actualizar(Empleado empleado);
	public void eliminar (Integer id);
	
	
	public Empleado seleccionarPorSalario(BigDecimal salario);
	public Empleado buscarPorSalarioCAQ(BigDecimal salario);
}
