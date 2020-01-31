package com.ocaso.seguros.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ocaso.seguros.modelo.Seguro;


public class SeguroDAOImpl extends GenericDAOImplJpa<Seguro, Integer> implements SeguroDAO{
	EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();

	@Override
	public List<Seguro> dameListaSeguros() {
		
		List<Seguro> seguros = em.createQuery("select s from Seguro s").getResultList();
		return seguros;
						
	}

	@Override
	public List<Object[]> dameNIFyNombre() {
		
		TypedQuery<Object[]> q = em.createQuery
				("select s.nif, s.nombre from Seguro s ", Object[].class);
		

		return q.getResultList();
	}

	@Override
	public String dameNIFMAria(String nombre, String ape1, String ape2) {
		
		TypedQuery<String> q = em.createQuery
				("select s.nif from Seguro s where s.nombre = :nombre"
						+ " and s.ape1 = :ape1 and s.ape2 = :ape2 ", String.class);
		
		q.setParameter("nombre", nombre);
		q.setParameter("ape1", ape1);
		q.setParameter("ape2", ape2);

		return q.getSingleResult();
		
				}
	
	/*
	 * 8. Calcular cuántos seguros hay. Haz que se muestren en pantalla.
	 * El TypedQuery lo he puesto como long porque me daba error de conversión.
	 */
	
	
	@Override
	public Long cuentaSeguros() {

		TypedQuery<Long> numSeguros = em.createQuery("select count(s.id) "
				+ "from Seguro s", Long.class);
		return numSeguros.getSingleResult();
		 
	}

	
	/*
	 * 9. Mostrar para cada seguro, el nombre, el nif y cuántas asistencias médicas posee.
	 */
	@Override
	public List<Object[]> ejercicio9() {

		TypedQuery <Object[]> q = em.createQuery("select s.nombre, s.nif, count(*) "
				+ "from Seguro s join Asistencia a on s.id = a.seguro group by s.id", Object[].class);
				
		return q.getResultList();
	}

	@Override
	public List<Object[]> mostrarAlergias() {

		
		TypedQuery <Object[]> q = em.createQuery("select s, e.nombreAlergia from Seguro s join Enfermedad e "
				+ "on s.enfermedad = e.id ", Object[].class);
				
		return q.getResultList();
	}

	@Override
	public List<Object[]> ejercicio11() {

		List<Object[]> idSeguro = em.createQuery("select s.id, a.id from Seguro s join Asistencia"
				+ " a on s.id = a.seguro").getResultList();

		return idSeguro;
	}

}
