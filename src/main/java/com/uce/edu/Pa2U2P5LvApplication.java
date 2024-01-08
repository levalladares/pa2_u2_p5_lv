package com.uce.edu;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;
import com.uce.edu.service.LibroServiceImpl;

@SpringBootApplication
public class Pa2U2P5LvApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// libro con autores 
		Libro l1 = new Libro();
		l1.setTitulo("las Catilinarias");
		l1.setFechaPublicaciom(LocalDate.now());
		
		
		Autor a1= new Autor();
		a1.setNombre("Jose Rios");	
		a1.setNacional("peruano");
		this.autorService.guardar(a1);
		
		Autor a2= new Autor();
		a2.setNombre("Juan Montalvo");	
		a2.setNacional("ecuatoriano");
		this.autorService.guardar(a2);
		
		Set<Autor> autores = new HashSet<Autor>();
		autores.add(a2);
		autores.add(a1);
		
		l1.setAutores(autores);
		
		Set<Libro> libros = new HashSet<Libro>();
		libros.add(l1);
		
		a1.setLibros(libros);
		a2.setLibros(libros);
		
		this.iLibroService.guardar(l1);
		
		
		
		Set<Autor> autor = new HashSet<Autor>();
		Set<Libro> libros2 = new HashSet<Libro>();
		//autor con  libros
		Autor a3 = new Autor();
		a3.setNacional("chileno");
		a3.setNombre("Isabel Allende");
		a3.setLibros(libros2);
		
		Libro l2 = new Libro();
		l2.setTitulo("Violeta");
		l2.setFechaPublicaciom(LocalDate.now());
		l2.setAutores(autor);
		this.iLibroService.guardar(l2);
		
		Libro l3 = new Libro();
		l3.setTitulo("Violeta");
		l2.setAutores(autor);
		l3.setFechaPublicaciom(LocalDate.now());
		this.iLibroService.guardar(l3);
		libros2.add(l2);
		libros2.add(l3);
		
		
		
		
		
		
		autor.add(a3);
		this.autorService.guardar(a3);
		
		
		
	}

}
