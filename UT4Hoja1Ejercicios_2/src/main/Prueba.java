package main;

import java.time.LocalTime;
import java.util.Date;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Seguro;
import utilidades.Utilidades;
import modelo.Seguro.TipoSeguro;

public class Prueba {
	
	public static void main(String[] args) {
		
		
		Seguro s = new Seguro();
		s.setNif("cdcddx2");
		s.setNombre("MayorEdad2");
		s.setApe1("con");
		s.setApe2("Anotaciones");
		s.setEdad(21);
		s.setSexo(1);
		//Modifico casado para que sea un String
		s.setCasado("N");
		s.setNumHijos(0);
		s.setFechaCreacion(new Date());
		s.setTipoSeguro(TipoSeguro.COCHE);
		s.setMayorEdad(s.calculaMayorEdad(s.getEdad()));
		
		s.setFechaNacimiento(new Date());
		s.setHoraContacto(LocalTime.now());
		
		s.setCodigo(new char[] {'a','e'});
		s.setComentarios("Te vamos a subir la cuota");
		
		//almacenamos en la base de datos dicho Seguro
		almacenaSeguro(s);
		
		//Ahora traemos de vuelta este mismo seguro
		//para ello cogemos el id de este Seguro y se lo pasamos a reuperarSeguro
		
		Seguro sR = recuperaSeguro(s.getIdSeguro());

		
		//Ahora actualizaremos en campo nombre de la base de datos
		sR.setNombre("Mator dedad Actualizada.");
		actualizaSeguro(sR);
	
		Seguro s1 = new Seguro();
		s1.setNif("123564");
		borraSeguro(s1);
		//He comprobado y en mi base de datos ya no está este seguro.
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}
		
	/**
	 * Método para borrar un Seguro
	 * 
	 * @param seguro s
	 */
	public static void borraSeguro(Seguro s) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(s);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			
			session.close();
		}

	}

	/**
	 * Método para actualizar un Seguro
	 * 
	 * @param emp
	 */
	public static void actualizaSeguro(Seguro s) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.update(s);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error al actualizar");
		} finally {
			session.close();
		}

	}

	/**
	 * Método para almacenar un Seguro
	 * 
	 * @param emp
	 */
	public static void almacenaSeguro(Seguro s) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(s);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error al almacenar el seguro.");
		} finally {
			session.close();
		}

	}

	/**
	 * Método para recuperar un Seguro
	 * 
	 * @param id
	 * @return
	 */
	public static Seguro recuperaSeguro(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Seguro s = new Seguro();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el Seguro
		try
		{
			s = (Seguro) session.load(Seguro.class, id);
			System.out.println("Datos del Seguro recuperado:"
					+ s.toString());
			// Commit de la transacción
			session.getTransaction().commit();
		}catch (ObjectNotFoundException e) {
				System.out.println("Dicho seguro no se encontró en la base de datos.");
		} finally {
			session.close();
		}
		
		
		return s;
	}

}
