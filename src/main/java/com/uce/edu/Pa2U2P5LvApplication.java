package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Habitacion> habitaciones = new ArrayList<>();

		Hotel hot1 = new Hotel();
		hot1.setDireccion("colon");
		hot1.setNombre("colon");

		Habitacion hab1 = new Habitacion();
		hab1.setClase("economica");
		hab1.setNumero("A1");
		hab1.setHotel(hot1);
		habitaciones.add(hab1);

		Habitacion hab2 = new Habitacion();
		hab2.setClase("presidencial");
		hab2.setNumero("A2");
		hab2.setHotel(hot1);
		habitaciones.add(hab2);

		hot1.setHabitaciones(habitaciones);

		this.hotelService.crear(hot1);

	}

}
