package com.ocaso.seguros.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ocaso.seguros.modelo.Asistencia;

public class AsistenciaDAOImpl extends GenericDAOImplJpa<Asistencia, Integer> implements AsistenciaDAO{

	EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();

	/*
	 * 4. Obtener aquellas AsistenciaMedica con importe mayor o igual a 10.000 €. Muestra
el idAsistenciaMedica en pantalla.
	 */
	@Override
	public List<Integer> dameNIFyNmostarAsistenciaMAyor1000ombre() {
		
		TypedQuery<Integer> q = em.createQuery
				("select a.id from Asistencia a ", Integer.class);
		
		return q.getResultList();
	}



	@Override
	public List<Integer> dameidAsistenciaBigDecimal(BigDecimal i, BigDecimal j) {

		TypedQuery<Integer> q = em.createQuery
				("select a.id from Asistencia a where a.importe >= :i "
						+ " and a.importe <= :j", Integer.class);
		q.setParameter("i", i);
		q.setParameter("j", j);

		return q.getResultList();
	}



	@Override
	public BigDecimal dameImporte() {
		TypedQuery<BigDecimal> q =  em.createQuery("select sum "
				+ "(a.importe) from Asistencia a", BigDecimal.class);
		
		return q.getSingleResult();
	}


	/*
	 * Este método lo he hecho con Double porque me daba un error de conversión.
	 */
	@Override
	public Double dameSaldoMedio() {
		TypedQuery<Double> q =  em.createQuery("select avg "
				+ "(a.importe) from Asistencia a", Double.class);
		
		return q.getSingleResult();
	}

	
	
}
