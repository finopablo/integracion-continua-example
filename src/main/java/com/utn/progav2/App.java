package com.utn.progav2;


import com.utn.progav2.services.PersonaService;
import org.hibernate.Session;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.util.HibernateUtil;
import org.joda.time.DateTime;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args) throws Exception
    {
			PersonaService service = new PersonaService();
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Persona p = service.newPersona("Pablo", "Fino", format.parse("17-05-1980"));
			service.save(p);
    }
}
