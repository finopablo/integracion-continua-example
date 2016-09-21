package com.utn.progav2;

import com.utn.progav2.entities.Persona;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by pablo on 12/09/16.
 */

public class PersonaTest  extends  TestCase {

      Persona persona;

      @Before
      public void setUp() throws ParseException {
            persona = new Persona();
            persona.setApellido("Apellido");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            persona.setFechaNacimiento( sdf.parse("1980-05-17"));
            persona.setNombre("Nombre");
      }

      @Test
      public void testApellido() {
            assertEquals("Checking apellido getter" , persona.getApellido(), "Apellido" );
      }
      @Test
      public void testNombre() {
            assertEquals("Checking Nombre getter" , persona.getNombre(), "Nombre" );
      }
      @Test
      public void testFechaNacimiento() throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            assertEquals("Checking Fecha Nacimiento Getter" , sdf.parse("1980-05-17") , persona.getFechaNacimiento() );
      }
      @Test
      public void testEdad() {
            assertEquals("Checking Getter Edad" , 36, persona.getEdad());
      }

}
