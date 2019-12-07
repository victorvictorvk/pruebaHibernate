package utilidades;

 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
/**
 * Responsable de crear un objeto sesión (gestiona la conexión a BD de forma transparente
 * 
 */
public class Utilidades {
	
	 
	    //Factoria de sesión para crear objeto sesión a partir de XML
	    private static SessionFactory sessionFactory;
	     
	    private static SessionFactory buildSessionFactory() {
	        try {
	        	//Configuration configuration = new Configuration();
	        	//configuration.configure("hibernate.cfg.xml");
	            
	            // En Hibernate 5 basta con esto para la creación de sesión
	        	// si se encuentran los ficheros de configuración accesibles
	            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	            
	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // En un caso real se registra en un log
	            System.err.println("Falló la creación de la factoría de sesiones inicial." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    /*
	     * Método estático (Fachada) para crear la factoría de sesiones
	     */
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }

}
