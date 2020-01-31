package com.ocaso.seguros.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the seguro database table.
 * 
 */
@Entity
@Table(name="seguro")
@NamedQuery(name="Seguro.findAll", query="SELECT s FROM Seguro s")
public class Seguro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	enum TipoSexo {HOMBRE,MUJER};
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ape1;

	private String ape2;

	@Type(type="yes_no")
	private boolean casado;

	private int edad;

	@Type(type="yes_no")
	private boolean embarazada;

	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@Column(nullable=false, unique=true)
	private String nif;

	private String nombre;

	private int numHijos;

	//Como este enumerado lo almaceno como ordinal no me hace falta anotación
	private TipoSexo sexo;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="seguro", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Asistencia> asistencias;

	//uni-directional one-to-one association to Cobertura
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="coberturaId", referencedColumnName="id")
	private Cobertura cobertura;

	//uni-directional one-to-one association to Enfermedad
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="enfermedadId", referencedColumnName="id")
	private Enfermedad enfermedad;

	public Seguro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public boolean getCasado() {
		return this.casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean getEmbarazada() {
		return this.embarazada;
	}

	public void setEmbarazada(boolean embarazada) {
		this.embarazada = embarazada;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumHijos() {
		return this.numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public TipoSexo getSexo() {
		return this.sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setSeguro(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setSeguro(null);

		return asistencia;
	}

	public Cobertura getCobertura() {
		return this.cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public Enfermedad getEnfermedad() {
		return this.enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	@Override
	public String toString() {
		return "Seguro [id=" + id + ", ape1=" + ape1 + ", ape2=" + ape2 + ", casado=" + casado + ", edad=" + edad
				+ ", embarazada=" + embarazada + ", fechaCreacion=" + fechaCreacion + ", nif=" + nif + ", nombre="
				+ nombre + ", numHijos=" + numHijos + ", sexo=" + sexo + ", cobertura="
				+ cobertura + "]";
	}

}