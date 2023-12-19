package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Ciudadano ciud1 = new Ciudadano();
//		ciud1.setNombre("Luis");
//		ciud1.setApellido("Valladares");
//		this.ciudadanoService.guardar(ciud1);
		
		
		
		
		Empleado empl1 = new Empleado();
		empl1.setFechaIngreso(LocalDate.now());
		empl1.setSalario(new BigDecimal(300));
		empl1.setCiudadano(this.ciudadanoService.buscar(2));
		this.empleadoService.guardar(empl1);
		
		
		
		
		
		
		
	}

}
