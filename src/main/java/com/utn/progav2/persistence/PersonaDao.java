package com.utn.progav2.persistence;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by pablo on 12/09/16.
 */
public class PersonaDao extends  AbstractDao<Persona> {


  public PersonaDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public List<Persona> getAll() {
      Session session = this.sessionFactory.openSession();
      List<Persona> personas = session.createQuery("FROM Persona").list();
      session.close();
      return personas;
  }

  public void save(Persona p ) {
    Session session = this.sessionFactory.openSession();
    Transaction t = session.beginTransaction();
    session.save(p);
    t.commit();
    session.close();
  }

  public Persona getById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Persona persona = (Persona) session.get(Persona.class, id);
    return persona;
  }
}
