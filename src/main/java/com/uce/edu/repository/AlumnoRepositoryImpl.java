package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Alumno seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);

	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Alumno alu = this.seleccionar(id);
		this.entityManager.remove(alu);

	}

	@Override
	public Alumno seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM alumno a WHERE a.alum_nombre = :nombre",
				Alumno.class);
		myQuery.setParameter("nombre", nombre);
		return (Alumno) myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorNombreCriteria(String nombre) {
		// TODO Auto-generated method stub
		// SELECT a FROM Alumno a WHERE a.nombre = :dato
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Alumno> myCriteriaQuery = myCriteriaBuilder.createQuery(Alumno.class);
		Root<Alumno> myFrom = myCriteriaQuery.from(Alumno.class);
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		myCriteriaQuery.select(myFrom).where(condicionNombre);
		TypedQuery<Alumno> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
