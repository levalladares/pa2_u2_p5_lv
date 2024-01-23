package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciu = this.seleccionar(id);
		this.entityManager.remove(ciu);

	}

	@Override
	public Empleado seleccionarCPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e From Empleado e WHERE e.ciudadano.cedula = :cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiud(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula= :cedula",
				Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

	public Ciudadano seleccionarCiuPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c From Ciudadano c WHERE c.cedula = :cedula", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellidoCAQ(String apellido) {
		// TODO Auto-generated method stub
		// SELECT c FROM Ciudadano c WHERE c.apellido = :dato

		// 0.- creamos una instancia de la interfaz CriteriaBuilder a partir de un
		// entitymanager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.- Determinamos el tipo de retorno que va a tener mi consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2.- Construir nuestro SQL
		// 2.1- Determinar el FROM (Root)
		// no necesariamente el FROM es igual al tipo de retorno
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		// 2.2- Construir las condiciones (WHERE) del sql
		// en criteria api query las condiciones se las conoce como "PREDICATE"
		// c.apellido = :dato
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		// 3.- Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		// 4.- ejecutamos la consulta con un typed query
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// 0.- creamos una instancia de la interfaz CriteriaBuilder a partir de un
		// entitymanager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.- Determinamos el tipo de retorno que va a tener mi consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2.- Construir nuestro SQL
		// 2.1- Determinar el FROM (Root)
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		// 2.2- Construir las condiciones (WHERE) del sql

		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			Predicate condicion1 = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
			condicionGenerica = condicion1;
		} else if (cedula.startsWith("05")) {
			Predicate condicion2 = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
			condicionGenerica = condicion2;
		} else {
			Predicate condicion3 = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
			condicionGenerica = condicion3;
		}

		// 3.- Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		
		// 4.- ejecutamos la consulta con un typed query
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// 0.- creamos una instancia de la interfaz CriteriaBuilder a partir de un
		// entitymanager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.- Determinamos el tipo de retorno que va a tener mi consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2.- Construir nuestro SQL
		// 2.1- Determinar el FROM (Root)
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		// 2.2- Construir las condiciones (WHERE) del sql

		Predicate condicionTotal = null;
		//c.nombre = :nombre
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		//c.apellido = :apellido
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		if (cedula.startsWith("17")) {
			//c.nombre = :nombre or c.apellido = :apellido
			condicionTotal = myCriteriaBuilder.or(condicionNombre,condicionApellido);
		} else if (cedula.startsWith("05")) {
			//c.nombre = :nombre and c.apellido = :apellido
			condicionTotal = myCriteriaBuilder.and(condicionNombre,condicionApellido);
		} 

		// 3.- Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		
		// 4.- ejecutamos la consulta con un typed query
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}
}
