package com.utn.progav2.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {
	
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private Date fechaNacimiento;
	
	
	public Persona(){
	}
	

	@Id
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
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
