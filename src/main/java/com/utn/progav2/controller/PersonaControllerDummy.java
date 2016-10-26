package com.utn.progav2.controller;

import com.utn.progav2.request.PersonaRequest;
import com.utn.progav2.response.PersonaWrapper;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Profile("dummy")
@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class PersonaControllerDummy implements PersonaControllerInterface {


    @RequestMapping("/persona/{id}")
    public @ResponseBody ResponseEntity<PersonaWrapper> getById(@PathVariable("id") int id) {
        PersonaWrapper p  = new PersonaWrapper();
        p.setApellido("HOLA");
        p.setNombre("pero");
        p.setEdad(10);
        p.setFechaNacimiento("12/06/2001");
        return new ResponseEntity<PersonaWrapper>(p, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonaWrapper>> getAll() {
        return new ResponseEntity<List<PersonaWrapper>>(new ArrayList<PersonaWrapper>(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonaWrapper>> getBySurname(String apellido) {
        PersonaWrapper p  = new PersonaWrapper();
        p.setApellido("HOLA");
        p.setNombre("pero");
        p.setEdad(10);
        p.setFechaNacimiento("12/06/2001");
        List<PersonaWrapper> l = new ArrayList<PersonaWrapper>();
        l.add(p);
        return new ResponseEntity<List<PersonaWrapper>>(l,HttpStatus.OK);
    }

    @Override
    public ResponseEntity addPersona(PersonaRequest request) {
        return null;
    }


}
