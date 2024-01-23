package com.uce.edu.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
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
public class EmpleadoRepositoryImpl implements IEmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado emp = this.seleccionar(id);
		this.entityManager.remove(emp);
	}

	@Override
	public Empleado seleccionarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM empleado e WHERE e.empl_salario= :salario", Empleado.class);
		myQuery.setParameter("salario", salario);
		return (Empleado)myQuery.getSingleResult();
	}

	@Override
	public Empleado seleccionarPorSalarioCAQ(BigDecimal salario) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> myCriteriaQuery = myCriteriaBuilder.createQuery(Empleado.class);
		Root<Empleado> myFrom = myCriteriaQuery.from(Empleado.class);
		Predicate condicionTotal = null;
		Predicate condicionSalario = myCriteriaBuilder.greaterThan(myFrom.get("salario"),salario);
		Predicate condicionSalario2 = myCriteriaBuilder.lessThan(myFrom.get("salario"),salario);
		if(salario.equals(new BigDecimal(500))) {
			condicionTotal = condicionSalario;
		}else {
			condicionTotal = condicionSalario2;
		}
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Empleado> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
