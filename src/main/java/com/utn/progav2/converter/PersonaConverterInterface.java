package com.utn.progav2.converter;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.response.PersonaWrapper;

/**
 * Created by pablo on 12/10/16.
 */
public abstract class PersonaConverterInterface {

  String dateFormat;

  public abstract PersonaWrapper convert(Persona persona);
}
