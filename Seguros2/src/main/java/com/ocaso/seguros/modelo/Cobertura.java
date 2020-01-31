package com.ocaso.seguros.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the cobertura database table.
 * 
 */
@Entity
@Table(name="cobertura")
@NamedQuery(name="Cobertura.findAll", query="SELECT c FROM Cobertura c")
public class Cobertura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Type(type="true_false")
	private boolean dental;

	private boolean fecundacionInVitro;

	private boolean oftalmologia;

	public Cobertura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getDental() {
		return this.dental;
	}

	public void setDental(boolean dental) {
		this.dental = dental;
	}

	public boolean getFecundacionInVitro() {
		return this.fecundacionInVitro;
	}

	public void setFecundacionInVitro(boolean fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}

	public boolean getOftalmologia() {
		return this.oftalmologia;
	}

	public void setOftalmologia(boolean oftalmologia) {
		this.oftalmologia = oftalmologia;
	}


}