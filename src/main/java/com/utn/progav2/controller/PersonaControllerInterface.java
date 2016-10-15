package com.utn.progav2.controller;

import com.utn.progav2.entities.Persona;
import com.utn.progav2.request.PersonaRequest;
import com.utn.progav2.response.PersonaWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 12/10/16.
 */
public interface PersonaControllerInterface {



    PersonaWrapper getById( int id);
    List<PersonaWrapper> getAll();
    List<PersonaWrapper> getBySurname(String apellido) ;
    ResponseEntity addPersona(PersonaRequest request);


}
