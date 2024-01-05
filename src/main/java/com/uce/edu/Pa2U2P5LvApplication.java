package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IEmpleadoService empleadoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//crear ciudadano 
		Ciudadano c1 = new Ciudadano();
		c1.setNombre("Estela");
		c1.setApellido("Estrella");
		this.ciudadanoService.guardar(c1);
		System.out.println(c1);
		
		System.out.println("busca");
		//buscar ciudadano 
		System.out.println(this.ciudadanoService.buscar(1));
		
		//actualizar ciudadano 
		Ciudadano c2 = this.ciudadanoService.buscar(1);
		c2.setApellido("AAARTE");
		this.ciudadanoService.actualizar(c2);
		System.out.println(c2);
		
		System.out.println("agrega");
		//crear empleado
		Empleado e1 = new Empleado();
		e1.setFechaIngreso(LocalDate.now());
		e1.setSalario(new BigDecimal(450));
		e1.setCiudadano(this.ciudadanoService.buscar(1));
		this.empleadoService.guardar(e1);
		System.out.println(e1);
		
		System.out.println("busca");
		//buscar empleado
		System.out.println(this.empleadoService.buscar(1));
		
		System.out.println("actualiza");
		//actualizar empleado
		Empleado e2 = this.empleadoService.buscar(1);
		e2.setFechaIngreso(LocalDate.of(2020, 12, 23));
		this.empleadoService.actualizar(e2);
		System.out.println(e2);
		
		System.out.println("eliminaaaaaaaaaaaaaaaaaar");
		// eliminar empleado/ciudadano
		this.empleadoService.eliminar(1);
		this.ciudadanoService.eliminar(1);
		
		
	}

}
