package utilidades;

 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
/**
 * Responsable de crear un objeto sesión (gestiona la conexión a BD de forma transparente
 * 
 * 
 */
public class Utilidades {
	
	 
    //Factoria de sesi�n para crear objeto sesi�n a partir de XML
    private static SessionFactory sessionFactory;
     
    private static SessionFactory buildSessionFactory() {
        try {
            // Creamos una factor�a de sesiones con los datos de hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Configuraci�n de Hibernate Cargada");
             
            /*
             * estas lineas las quitamos
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Servicio de registro de Hibernate Realizado");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             */
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            return sessionFactory;
        }
        catch (Throwable ex) {
            // En un caso real se registra en un log
            System.err.println("Fall� la creaci�n de la factor�a de sesiones inicial." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /*
     * M�todo est�tico (Fachada) para crear la factor�a de sesiones
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

}