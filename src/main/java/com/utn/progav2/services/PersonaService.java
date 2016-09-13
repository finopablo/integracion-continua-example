package com.utn.progav2.services;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.persistence.PersonaDao;
import com.utn.progav2.util.HibernateUtil;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * Created by pablo on 12/09/16.
 */
public class PersonaService {

  PersonaDao personaDao;

  public PersonaService() {
    this.personaDao = new PersonaDao(HibernateUtil.getSessionFactory());
  }


  public List<Persona> getAll() {
        return personaDao.getAll();
  }


  public Persona getPersona(int id) {
      return this.getPersona(id);
  }

  public void save(Persona p) {
      this.personaDao.save(p);
  }

  public Persona newPersona(String nombre, String apellido, Date fechaNacimiento ) {
      Persona p = new Persona();
      p.setNombre(nombre);
      p.setApellido(apellido);
      p.setFechaNacimiento(fechaNacimiento);
      return p;
  }

}
