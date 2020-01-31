package com.ocaso.seguros.persistencia;

import java.util.List;

import com.ocaso.seguros.modelo.Seguro;

public interface SeguroDAO extends GenericDAO<Seguro, Integer>{

	List<Seguro> dameListaSeguros();

	List<Object[]> dameNIFyNombre();

	String dameNIFMAria(String nombre, String ape1, String ape2);

	Long cuentaSeguros();

	List<Object[]> ejercicio9();

	List<Object[]> mostrarAlergias();

	List<Object[]> ejercicio11();

	

}
