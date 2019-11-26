package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.modelo.Empleado;
import com.hibernate.utilidades.Utilidades;

public class Prueba {
	public static void main(String[] args) {
		Empleado emp = new Empleado();
		Empleado empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());

		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
		session.save(emp);
		// Commit de la transacción: si no, no se hace persistente en BD, sólo actualiza el objeto
		session.getTransaction().commit();
		System.out.println("Employee ID=" + emp.getId());
				
		//Recuperamos un objeto cuyo identificador conocemos
		//session.beginTransaction();
		empR=(Empleado)session.load(Empleado.class,  emp.getId());
		//session.getTransaction().commit();
		System.out.println("Employee=" +empR.getId()+":"+ empR.getNombre()+":"+empR.getFecha());		

		// Cerramos la factoria de sesiones, si no el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
