package com.utn.progav2;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.persistence.PersonaDao;
import com.utn.progav2.util.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


/**
 * Created by pablo on 12/09/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({HibernateUtil.class})
public class PersonaDaoTest extends TestCase {

  PersonaDao dao;
  HibernateUtil hibernateUtil;
  SessionFactory sessionFactory;
  Session session;
  Query query;


  @Before
  public void setUp() throws ParseException {
    Persona p = new Persona();
    p.setApellido("Apellido");
    p.setNombre("Nombre");
    p.setEdad(10);
    List<Persona> list = new ArrayList<Persona>();
    list.add(p);
    try {
      sessionFactory = mock(SessionFactory.class);
      query = mock(Query.class);
      session = mock(Session.class);
      when(session.createQuery(anyString())).thenReturn(query);
      when(query.setParameter(anyString(), Matchers.anyObject())).thenReturn(query);
      when(query.list()).thenReturn(list);
      when(sessionFactory.openSession()).thenReturn(session);
      when(session.get(Persona.class, 10)).thenReturn(p);
      dao = new PersonaDao(sessionFactory);
    } catch(Exception e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void testGetAllPersonas() {
    List<Persona> l = dao.getAll();
    assertTrue(l.size() == 1);
    assertEquals(l.get(0).getApellido(), "Apellido");
  }

  @Test
  public void testGetBySurname() {
    List<Persona> l = dao.getBySurname("Fino");
    assertTrue(l.size() == 1);
    assertEquals(l.get(0).getApellido(), "Apellido");
  }


  @Test
  public void testGetById() {
    Persona p = dao.getById(10);
    assertEquals(p.getApellido(), "Apellido");
  }

}
