
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Prueba {
	
	public static void main(String[] args) {
		
		
		Profesor p = new Profesor("Profesoras", "oneToone", "ClavePrimaria");
		Direccion d = new Direccion("Lunas", 15, "AAA", "EEE");

		p.setDireccion(d);
		almacenaProfesor(p);
		
		Profesor pR = recuperaProfesor(p.getId());
	
		// Cerramos la factoria de sesiones, si no el programa no finalizará
		Utilidades.getSessionFactory().close();
	}
		
	/**
	 * Método para borrar un Seguro
	 * 
	 * @param seguro s
	 */
	public static void borraSeguro(Profesor s) {
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
	public static void actualizaProfesor(Profesor s) {
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
	public static void almacenaProfesor(Profesor p) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(p);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error al almacenar el Profesor. " + e.getMessage());
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
	public static Profesor recuperaProfesor(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Profesor s = new Profesor();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el Seguro
		try
		{
			s = session.load(Profesor.class, id);
			System.out.println("Datos del Profesor recuperado:"
					+ s.toString());
			// Commit de la transacción
			session.getTransaction().commit();
		}catch (ObjectNotFoundException e) {
				System.out.println("Dicho Profesor no se encontró en la base de datos.");
		} finally {
			session.close();
		}
		
		
		return s;
	}
	
	public static Direccion recuperaDireccion(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Direccion s = new Direccion();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el Seguro
		try
		{
			s = session.load(Direccion.class, id);
			System.out.println("Datos de la Direccion recuperado:"
					+ s.toString());
			// Commit de la transacción
			session.getTransaction().commit();
		}catch (ObjectNotFoundException e) {
				System.out.println("Dicho Direccion no se encontró en la base de datos.");
		} finally {
			session.close();
		}
		return s;
		

}
}
