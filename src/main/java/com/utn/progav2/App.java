package com.utn.progav2;

import java.util.Date;

import org.hibernate.Session;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
    		Persona p = new Persona();
    		p.setNombre("Pablo");
    		p.setApellido("Fino");
    		p.setEdad(25);
    		p.setFechaNacimiento(new Date());
    		session.save(p);
    		session.getTransaction().commit();

    }
}
