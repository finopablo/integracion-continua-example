package com.utn.progav2.controller;

import com.utn.progav2.converter.PersonaConverterInterface;
import com.utn.progav2.entities.Persona;

import com.utn.progav2.request.PersonaRequest;
import com.utn.progav2.response.PersonaWrapper;
import com.utn.progav2.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 20/09/16.
 */

@RestController
@RequestMapping(
    value = "/api",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class PersonaController  {

  private PersonaService personaService;
  private PersonaConverterInterface converter;

  @Autowired
  public PersonaController(PersonaService personaService, @Qualifier("uglyConverter") PersonaConverterInterface converter) {
    this.personaService = personaService;
   this.converter = converter;
  }





  @RequestMapping("/personas/{id}")
  public @ResponseBody ResponseEntity<PersonaWrapper>
  getById(@RequestHeader("usuario") String userName,
          @PathVariable("id") int id) {
    Persona per = personaService.getPersona(id);
    if (per != null) {
      PersonaWrapper p = converter.convert(per);
      return  new ResponseEntity<PersonaWrapper>(p, HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping("/personas/")
  public @ResponseBody  ResponseEntity<List<PersonaWrapper>> getAll(
          @RequestHeader("usuario") String usuario) {
   //Con esto obtengo el usuario que pasamos por parametro en el RequestHeader
    System.out.println(usuario);
    List<Persona> list = personaService.getAll();
    if (!list.isEmpty()) {
      return new ResponseEntity<List<PersonaWrapper>>(this.convertList(list), HttpStatus.OK);
    } else {
      return new ResponseEntity<List<PersonaWrapper>>(HttpStatus.NO_CONTENT);
    }
  }

  @RequestMapping(value = "/personas", method = RequestMethod.GET)
  public ResponseEntity<List<PersonaWrapper>> getBySurname(
          @RequestParam ("ape") String apellido) {
    List<Persona> list = personaService.getByApellido(apellido);
    if (!list.isEmpty()) {
      return new ResponseEntity<List<PersonaWrapper>>(this.convertList(list), HttpStatus.OK);
    } else {
      return new ResponseEntity<List<PersonaWrapper>>(HttpStatus.NO_CONTENT);
    }
  }

  @RequestMapping(value = "/personas",
          method = RequestMethod.POST,
          consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addPersona(
          @RequestBody PersonaRequest request) {
    try {
      personaService.newPersona(request.getNombre(), request.getApellido(), request.getFechaNacimiento());
      return new ResponseEntity(HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  private List<PersonaWrapper> convertList(List<Persona> personas) {
    List<PersonaWrapper> personaWrapperList = new ArrayList<PersonaWrapper>();
    for (Persona p : personas) {
      personaWrapperList.add(converter.convert(p));
    }
    return personaWrapperList;
  }


}
