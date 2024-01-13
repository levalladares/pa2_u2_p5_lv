package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro l1 = this.seleccionar(id);
		this.entityManager.remove(l1);
	}

	@Override
	public void insertar(Libro2 libro2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		//SQL: select * From libro l where l.libr_titulo = ?
		//jpql: SELECT l FROM Libro l WHERE l.titulo = :variable
		Query myQuery=this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :variable");
		myQuery.setParameter("variable", nombre);
		return (Libro)myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicaion(LocalDate fechaPublicacion) {
		// TODO Auto-generated method stub
		//SQL: SELECT * FROM libro l WHERE l.libr_fecha_publicacion >=?
		//JPQL: SELECT l FROM Libro l WHERE l.fechaPublicaciom >= :fecha
		Query myQuery=this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicaciom >= :fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTitiloTyped(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery=this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaTyped(LocalDate fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery= this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicaciom >= :fecha",Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery=this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo",Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDate fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery =this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	

}
