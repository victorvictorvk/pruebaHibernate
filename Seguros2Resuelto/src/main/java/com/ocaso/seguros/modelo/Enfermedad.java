package com.ocaso.seguros.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the enfermedad database table.
 * 
 */
@Entity
@Table(name="enfermedad")
@NamedQuery(name="Enfermedad.findAll", query="SELECT e FROM Enfermedad e")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Type(type="yes_no")
	private boolean corazon;

	@Type(type="yes_no")
	private boolean estomacal;

	@Type(type="yes_no")
	@Column(name="rinyones")
	private boolean riñones;
	
	@Type(type="yes_no")
	private boolean alergia;
	
	private String nombreAlergia;


	public Enfermedad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public boolean getCorazon() {
		return this.corazon;
	}

	public void setCorazon(boolean corazon) {
		this.corazon = corazon;
	}

	public boolean getEstomacal() {
		return this.estomacal;
	}

	public void setEstomacal(boolean estomacal) {
		this.estomacal = estomacal;
	}
	
	public boolean getRiñyones() {
		return this.riñones;
	}

	public void setRiñones(boolean riñones) {
		this.riñones = riñones;
	}
	
	public boolean getAlergia() {
		return this.alergia;
	}

	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}

	public String getNombreAlergia() {
		return this.nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}



}