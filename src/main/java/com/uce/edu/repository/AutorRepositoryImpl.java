package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class AutorRepositoryImpl implements IAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor a1 = this.seleccionar(id);
		this.entityManager.remove(a1);
	}

	@Override
	public Libro2 seleccionarPA(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Libro2> myQuery = this.entityManager.createQuery(
				"SELECT l FROM Libro2 l JOIN FETCH l.autoresLibros au WHERE au.autor2.nombre = :nombre", Libro2.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Autor seleccionarCriteriaAQ(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Autor> myCriteriaQuery = myCriteriaBuilder.createQuery(Autor.class);
		Root<Autor> myFrom = myCriteriaQuery.from(Autor.class);
		Predicate condicionTotal = null;
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"),nombre);
		Predicate condicionNacionalidad = myCriteriaBuilder.equal(myFrom.get("nacional"),nacionalidad);
		if(nacionalidad.equals("ecuatoriano")) {
			condicionTotal = condicionNombre;
		}else {
			condicionTotal = condicionNacionalidad;
		}
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Autor> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
