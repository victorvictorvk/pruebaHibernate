package com.ocaso.seguros;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.ocaso.seguros.controlador.AsistenciaController;
import com.ocaso.seguros.controlador.SeguroController;
import com.ocaso.seguros.persistencia.Utilidades;


public class AppDao {
	public static void main( String[] args )
    {
		EntityManager em = null; 

		SeguroController s;
		AsistenciaController a;
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			s = new SeguroController();
			
			a = new AsistenciaController();
			
			
			s.mostrarTodosSeguros();
			s.mostrarNIFyNombre();
			
			
			s.mostrarNIFdeMariaGarciaLozano("NURIA", "PUERTO", "VILLANOVA");
			

			a.mostarAsistenciaMAyor1000();
			
			/*
			 * 5. Obtener el idAsistenciaMedica de todas las asistencias médicas cuyo importe esté entre
8.000 y 15.000 euros. Usa parámetros para los valores 8000 y 15000.
			 */
			//a.idAsistencia(8000, 15000);
			BigDecimal b1 = new BigDecimal(8000);
			BigDecimal b2 = new BigDecimal(15000);

			a.idAsistenciaBigDecimal(b1, b2);
			
			/*
			 * 6. Calcular la suma de todos los importes de todas las asistencias médicas.
			 */
			
			a.sumaImporte();
			/*
			 * 7. Calcular el saldo medio de todas las asistencias médicas.
			 */
			
			a.saldoMedio();
			
			/*
			 * 8. Calcular cuántos seguros hay. Haz que se muestren en pantalla.
			 */
			
			s.cuantosSegurosHay();
			
			s.ejercicio9();
			
			s.mostrarAlergiaSeguros();
			
			s.ejercicio11();
		}catch (Exception e ) {
			if (em != null) {
				e.printStackTrace();
				System.out.println("Se va a hacer rollback de la transacción");
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		Utilidades.closeEntityManagerFactory();
		
}
}