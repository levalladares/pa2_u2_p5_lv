package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
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
		//CRITERIA API QUERY
		//1
		System.out.println("1");
		Alumno al = this.alumnoService.buuscarPorNombreCriteria("Luis");
		System.out.println(al);
		//2
		System.out.println("2");
		Autor au1 = this.autorService.buscarCriteriaAQ("Jose Rios", "ecuatoriano");
		System.out.println(au1);
		//3
		System.out.println("3");
		Empleado e1 = this.empleadoService.buscarPorSalarioCAQ(new BigDecimal(500));
		System.out.println(e1);
		//4
		System.out.println("4");
		Ciudadano c1 = this.ciudadanoService.buscarPorCriteriaAndOr("Luis", "Valladres", "17345");
		System.out.println(c1);
		//5
		System.out.println("5");
		Ciudadano c2 =this.ciudadanoService.buscarPorApellidoCAQ("Zapata");
		System.out.println(c2);
		
	}

}
