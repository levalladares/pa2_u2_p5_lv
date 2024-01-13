package com.uce.edu;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QUERY");
		List<Libro> listaLibros=this.iLibroService.buscarPorFechaPublicaion(LocalDate.of(2024, 01, 06));
		for(Libro libro:listaLibros) {
			System.out.println(libro);
		}
		
		System.out.println("TYPED");
		Libro l1=this.iLibroService.buscarPorTitiloTyped("JAVA");
		System.out.println(l1);
		
		List<Libro> listaLibros2= this.iLibroService.buscarPorFechaTyped(LocalDate.of(2024, 01, 06));
		for(Libro libro: listaLibros2) {
			System.out.println(libro);
		}
		
		System.out.println("NAMED");
		Libro l2=this.iLibroService.buscarPorTituloNamed("JAVA");
		System.out.println(l2);
		
		List<Libro> listaLibros3= this.iLibroService.buscarPorFechaNamed(LocalDate.of(2024, 01, 06));
		for(Libro libro: listaLibros3) {
			System.out.println(libro);
		}
		
	}

}
