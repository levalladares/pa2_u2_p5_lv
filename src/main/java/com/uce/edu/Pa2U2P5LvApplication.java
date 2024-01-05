package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Habitacion> habitaciones= new ArrayList<>();
		//crear habitaciones
		Habitacion ha1 = new Habitacion();
		ha1.setClase("Basico");
		ha1.setNumero("aaaa1");
		this.habitacionService.guardar(ha1);
		habitaciones.add(ha1);
		
		//buscar
		System.out.println(this.habitacionService.buscar(1));
		
		//actualizar
		Habitacion ha2 = this.habitacionService.buscar(1);
		ha2.setClase("Lujo");
		System.out.println(ha2);
		
		
		
		// crear Hotel
		Hotel h1 = new Hotel();
		h1.setDireccion("Quito");
		h1.setNombre("Cielo");
		h1.setHabitaciones(habitaciones);
		this.hotelService.crear(h1);
		
		// buscar
		System.out.println(this.hotelService.buscar(1));
		// actualizar
		Hotel h2 = this.hotelService.buscar(1);
		h2.setDireccion("Cayambe");
		this.hotelService.actualizar(h2);
		//eliminar
		this.hotelService.eliminar(1);
		this.habitacionService.eliminar(1);
		
		
		
	}

}
