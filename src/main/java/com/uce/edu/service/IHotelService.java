package com.uce.edu.service;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {

	public void crear (Hotel hotel);
	public void actualizar(Hotel hotel);
	public void eliminar(Integer id);
	public Hotel buscar (Integer id);
	
	public Hotel buscarHotelPorDireccionNQ(String direccion);
	
}
