package com.utn.progav2.converter;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.response.PersonaWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * Created by pablo on 20/09/16.
 */
public class PersonaConverter implements PersonaConverterInterface {

    public String dateFormat;

    public PersonaConverter(String dateFormat) {
        this.dateFormat = dateFormat;
    }

     public PersonaWrapper convert(Persona persona) {
        PersonaWrapper p = new PersonaWrapper();
        p.setApellido(persona.getApellido());
        p.setNombre(persona.getNombre());
        p.setEdad(persona.getEdad());
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        p.setFechaNacimiento(sdf.format(persona.getFechaNacimiento()));
        return p;
    }

}
