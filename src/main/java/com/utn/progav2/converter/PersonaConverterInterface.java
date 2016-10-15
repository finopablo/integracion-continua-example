package com.utn.progav2.converter;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.response.PersonaWrapper;
import org.springframework.stereotype.Component;

/**
 * Created by pablo on 12/10/16.
 */
public interface PersonaConverterInterface {

  public PersonaWrapper convert(Persona persona);
}
