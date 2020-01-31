package com.ocaso.seguros.controlador;

import javax.persistence.EntityManager;

import com.ocaso.seguros.modelo.Seguro;
import com.ocaso.seguros.persistencia.SeguroDAO;
import com.ocaso.seguros.persistencia.SeguroDAOImpl;
import com.ocaso.seguros.persistencia.Utilidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class SeguroController {

	SeguroDAO seguroDAO;
	EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();

	
	public SeguroController()
	{
		seguroDAO = new SeguroDAOImpl();
	}
	
	//1. Obtener todos los seguros que hay en la base de datos.
	@SuppressWarnings("unchecked")
	public void mostrarTodosSeguros()
	{
		List<Seguro> seguros = seguroDAO.findAll();
				
		
		for (Seguro s: seguros)
		{
			System.out.println(s.toString());
		}
	}
	
	//2. Obtener solo las columnas NIF y Nombre de todos los seguros que hay en la base de datos.
	
	public void mostrarNIFyNombre()
	{
		List<Object[]> seguros = seguroDAO.dameNIFyNombre();
		
		for (Object[] s: seguros)
		{
			System.out.println("Seguro:"+ s[0]+ "; NIF: "+s[1] );
		}

	}
	
	//3. Obtener sólo el NIF para el seguro con nombre “Maria Garcia Lozano”. Usa el
	//método uniqueResult() y 3 parámetros con nombre para el nombre y los apellidos.
	
	public void mostrarNIFdeMariaGarciaLozano(String nombre, String ape1, String ape2)
	{
		String nif = seguroDAO.dameNIFMAria(nombre, ape1, ape2);
		if(nif != null)
		{
			System.out.println("El NIF es de "+nombre+ " es: " + nif);
		}else
		{
			System.out.println("No existe dicho nombre en la BBDD.");
		}
	}

	public void cuantosSegurosHay() {

		Long numSeguros = seguroDAO.cuentaSeguros();
		System.out.println("El numero de seguros es : " +numSeguros);
	}

	public void ejercicio9() {

		List<Object[]> informacion = seguroDAO.ejercicio9();
		
		for (Object[] s: informacion)
		{
			System.out.println("nombre:"+ s[0]+ "; NIF: "+s[1]
					+ " ; Num asistencias: " +s[2]);
		}
	}
	
	//10
	public void mostrarAlergiaSeguros()
	{
		List<Object[]> seguros = seguroDAO.mostrarAlergias();
				
		System.out.println("Ejercicio 10");
		
		for (Object[] s: seguros)
		{
			System.out.println(">>Seguro: "+s[0]+ " enfermedad: "+ s[1]);
		}
		//Tengo la BD rellenada con datos, y este método me imprime todos los atributos y al final el nombre de la enfermedad
		//Pero solo me imprime aquellos que tienen una enfermedad asignada.
	}

	public void ejercicio11() {

		List<Object[]> idSeguros = seguroDAO.ejercicio11();
		
		for (Object[] s: idSeguros)
		{
			System.out.println(">>Seguro numero : + " +s[0]+ " Asistencia médica: "+  s[1]);
		}
	}

}
