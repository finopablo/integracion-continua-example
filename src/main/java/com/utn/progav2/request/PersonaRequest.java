package com.utn.progav2.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pablo on 20/09/16.
 */
public class PersonaRequest {

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  @JsonProperty("nombre")
    String nombre;
  @JsonProperty("apellido")
    String apellido;
  @JsonProperty("fecha-nacimiento")
    String fechaNacimiento;
}
