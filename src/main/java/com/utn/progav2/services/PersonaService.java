package com.utn.progav2.services;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.persistence.PersonaDao;
import com.utn.progav2.util.HibernateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by pablo on 12/09/16.
 */
@Profile("prod")
@Service
public class PersonaService {

  @Autowired
  PersonaDao personaDao;

  public PersonaService() {
    this.personaDao = new PersonaDao(HibernateUtil.getSessionFactory());
  }


  public List<Persona> getAll() {
        return personaDao.getAll();
  }


  public Persona getPersona(int id) {
      return personaDao.getById(id);
  }

  public void newPersona(String nombre, String apellido, String fechaNacimiento)  throws ParseException  {
      Persona p = new Persona();
      p.setApellido(apellido);
      p.setNombre(nombre);
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      p.setFechaNacimiento(sdf.parse(fechaNacimiento));
      this.personaDao.save(p);
  }

  public List<Persona> getByApellido(String surname) {
    return personaDao.getBySurname(surname);
  }

}
