package com.ocaso.seguros.controlador;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.ocaso.seguros.persistencia.AsistenciaDAO;
import com.ocaso.seguros.persistencia.AsistenciaDAOImpl;
import com.ocaso.seguros.persistencia.Utilidades;

public class AsistenciaController {

		AsistenciaDAO asistenciaDAO;
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();

		public AsistenciaController()
		{
			asistenciaDAO = new AsistenciaDAOImpl();
		}

		//4. Obtener aquellas AsistenciaMedica con importe mayor o igual a 10.000 €. Muestra
		//el idAsistenciaMedica en pantalla.
		
		public void mostarAsistenciaMAyor1000() {

			List<Integer> asistencias = asistenciaDAO.dameNIFyNmostarAsistenciaMAyor1000ombre();
	
			
			for (Integer a: asistencias)
			{
				System.out.println(">>>Asistencias mayores que 10000: " + a);
			}
			
		}

	

		public void idAsistenciaBigDecimal(BigDecimal i, BigDecimal j) {

			List<Integer> asistencias = asistenciaDAO.dameidAsistenciaBigDecimal(i, j);

			
			if(!asistencias.isEmpty())
			{
				for (Integer a: asistencias)
				{

					System.out.println(">>>ID Asistencia: " + a);
				}
			}else
				System.out.println("No hay ningun resultado");
			
		}

		public void sumaImporte() {

			BigDecimal suma = asistenciaDAO.dameImporte();
			System.out.println("El importe total de todas las sumas es:  "+ suma);
		}

		public void saldoMedio() {

			Double saldoMedio = asistenciaDAO.dameSaldoMedio();
			System.out.println("El saldo medio es:  "+ saldoMedio);

		}

	

				
}
