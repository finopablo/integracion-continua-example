package com.utn.progav2.persistence;

import com.utn.progav2.entities.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pablo on 12/09/16.
 */

@Repository
public class PersonaDao extends  AbstractDao<Persona> {


  @Autowired
  public PersonaDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public List<Persona> getAll() {
      Session session = this.sessionFactory.openSession();
      List<Persona> personas = session.createQuery("FROM Persona").list();
      session.close();
      return personas;
  }

  public void save(Persona p) {
    Session session = this.sessionFactory.openSession();
    Transaction t = session.beginTransaction();
    session.save(p);
    t.commit();
    session.close();
  }

  public Persona getById(int id) {
    Session session = this.sessionFactory.openSession();
    Persona persona = (Persona) session.get(Persona.class, id);
    session.close();
    return persona;
  }


  public List<Persona> getBySurname(String surname) {
    Session session = this.sessionFactory.openSession();
    List<Persona> list = session.createQuery("FROM Persona where Apellido = :ape").setParameter("ape", surname).list();
    session.close();
    return list;
  }
}
