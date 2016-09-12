package com.utn.progav2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public static void main( String[] args)
    {
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
    		Persona p = new Persona();
    		p.setNombre("Pablo");
    		p.setApellido("Fino");
    		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			try {
    			p.setFechaNacimiento((formatter.parse("17-05-1980"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		session.save(p);
    		session.getTransaction().commit();

    }
}
