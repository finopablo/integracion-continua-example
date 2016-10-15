package com.utn.progav2.controller;

import com.utn.progav2.converter.PersonaConverter;
import com.utn.progav2.converter.PersonaConverterInterface;
import com.utn.progav2.entities.Persona;
import com.utn.progav2.request.PersonaRequest;
import com.utn.progav2.response.PersonaWrapper;
import com.utn.progav2.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 20/09/16.
 */
@Profile("prod")
@RestController
@RequestMapping(
    value = "/api",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class PersonaController implements PersonaControllerInterface {


  @Autowired
  PersonaService personaService;

  @Autowired
  @Qualifier("uglyConverter")
  PersonaConverterInterface converter;

  @RequestMapping("/persona/{id}")
    public @ResponseBody PersonaWrapper getById(@PathVariable("id") int id) {
      return converter.convert(personaService.getPersona(id));
  }

  @RequestMapping("/personas/")
  public @ResponseBody List<PersonaWrapper> getAll() {
    return this.convertList(personaService.getAll());
  }

  @RequestMapping("/personas/apellido/{ape}")
  public List<PersonaWrapper> getBySurname(@PathVariable("ape") String apellido) {
    return this.convertList(personaService.getByApellido(apellido));
  }


  @RequestMapping(value = "/persona", method = RequestMethod.POST)
  public ResponseEntity addPersona(@RequestBody PersonaRequest request) {
    try {
      personaService.newPersona(request.getNombre(), request.getApellido(), request.getFechaNacimiento());
      return new ResponseEntity(HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  private List<PersonaWrapper> convertList(List<Persona> personas ){
    List<PersonaWrapper> personaWrapperList = new ArrayList<PersonaWrapper>();
    for (Persona p : personas) {
      personaWrapperList.add(converter.convert(p));
    }
    return personaWrapperList;
  }


}
