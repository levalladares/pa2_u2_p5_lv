package com.uce.edu;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//   >>>>>>>>>>>>>>>>>>>>>>>>>>>ESTUDIANTE 
		//CREAR
//		Estudiante E1= new Estudiante();
//		E1.setNombre("Luis");
//		E1.setApellido("Valladares");
//		E1.setCedula("1723874545");
//		E1.setFechaNacimiento(LocalDate.of(1999, 02, 23));
//		this.estudianteService.guardar(E1);
//		System.out.println(E1);
		
//		//ACTUALIZAR
//		Estudiante E2 = this.estudianteService.buscar(12);
//		E2.setNombre("Joel");
//		this.estudianteService.actualizar(E2);
//		System.out.println(E2);
//		
//		//BUSCRA
//		System.out.println(this.estudianteService.buscar(12));
//		
//		//ELIMINAR
//		this.estudianteService.eliminar(11);
		
		
		
	//   >>>>>>>>>>>>>>>>>>>>>>>>>>>ALUMNO 
		//CREAR
		Alumno a1= new Alumno();
		a1.setNombre("Luis");
		this.alumnoService.guardar(a1);
		System.out.println(a1);
		
		Alumno a3= new Alumno();
		a3.setNombre("UWU");
		this.alumnoService.guardar(a3);
		
		//BUSCAR
		System.out.println(this.alumnoService.buscar(10));
		
		//ACTUALIZAR
		Alumno a2 = this.alumnoService.buscar(11);
		a2.setNombre("jorge");
		this.alumnoService.actualizar(a2);
		
		//ELIMINAR
		this.alumnoService.eliminar(11);
		
		
		
		
		
		
		
		
	}

}
