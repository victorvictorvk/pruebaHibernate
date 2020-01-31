package com.ocaso.seguros.persistencia;

import java.math.BigDecimal;
import java.util.List;

import com.ocaso.seguros.modelo.Asistencia;

public interface AsistenciaDAO extends GenericDAO<Asistencia, Integer>{

	List<Integer> dameNIFyNmostarAsistenciaMAyor1000ombre();


	List<Integer> dameidAsistenciaBigDecimal(BigDecimal i, BigDecimal j);


	BigDecimal dameImporte();


	Double dameSaldoMedio();
	
}
