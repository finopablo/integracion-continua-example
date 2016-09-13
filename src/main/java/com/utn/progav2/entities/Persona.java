package com.utn.progav2.entities;


import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas")
public class Persona {
	
	private int id;
	private String nombre;
	private String apellido;
	private long edad;
	private Date fechaNacimiento;
	
	
	public Persona(){
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_persona" , unique = true, nullable=false)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	
	@Column(name="nombre", nullable = false, length = 20)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="apellido", nullable = false, length = 20)
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Column(name="edad", nullable = true)
	public long getEdad() {
		long today = new Date().getTime();
		long fechaNac = this.getFechaNacimiento().getTime();
		long diff = (today - fechaNac);
		long year = (1000L*60L*60L*24L*365L);
		return diff / year ;

	}

	public void setEdad(long edad) {
		this.edad = edad;
	}
	@Column(name="fecha_nacimiento", nullable = true)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
