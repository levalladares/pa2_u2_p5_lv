package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//TYPED QUERY
		//1
		Empleado e1 = this.ciudadanoService.buscarCPorCedula("12345");
		System.out.println(e1);
		//2
		Ciudadano c1 = this.ciudadanoService.buscarCiuPorCedula("12345");
		System.out.println(c1);
		//3
		Hotel h1 = this.habitacionService.buscarPClase("Presidencial");
		System.out.println(h1);
		//4
		Libro2 l1 = this.autorService.seleccionarPA("Juan Montalvo2");
		System.out.println(l1);
		//5
		List<Libro> l2 = this.iLibroService.buscarPorFechaTyped(LocalDate.of(2024, 01, 07));
		for (Libro l : l2) {
			System.out.println(l);
		}
		
		//NATIVE QUERY
		//1
		Ciudadano c2 = this.ciudadanoService.buscarPorCedulaCiud("12345");
		System.out.println(c2);
		
		//2
		Hotel h2 = this.hotelService.buscarHotelPorDireccionNQ("Colon");
		System.out.println(h2);
		
		//3
		Empleado e2 = this.empleadoService.seleccionarPorSalario(new BigDecimal(500));
		System.out.println(e2);
		
		//4
		Habitacion ha1 = this.habitacionService.seleccionarPorNumero("01A");
		System.out.println(ha1);
		
		//5
		Alumno al = this.alumnoService.buscarPorNombre("Luis");
		System.out.println(al);
	}

}
