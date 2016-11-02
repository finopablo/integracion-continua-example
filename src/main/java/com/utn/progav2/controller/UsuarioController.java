package com.utn.progav2.controller;

import com.utn.progav2.converter.PersonaConverterInterface;
import com.utn.progav2.entities.Persona;
import com.utn.progav2.entities.Usuario;
import com.utn.progav2.request.PersonaRequest;
import com.utn.progav2.response.PersonaWrapper;
import com.utn.progav2.services.PersonaService;
import com.utn.progav2.services.UsuarioService;
import com.utn.progav2.util.SessionData;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
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
    value = "/",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class UsuarioController {


  @Autowired
  UsuarioService usuarioService;

  @Autowired
  SessionData sessionData;

  @RequestMapping("/login")
  public @ResponseBody ResponseEntity<String> getById(@RequestParam("user") String nombreUsuario, @RequestParam("pwd") String pwd){
      Usuario u = usuarioService.login(nombreUsuario, pwd);
      if (null != u) {
        String sessionId = sessionData.addSession(u);
        return new ResponseEntity<String>(sessionId, HttpStatus.OK);
      }
      return new ResponseEntity(HttpStatus.FORBIDDEN);
  }


  @RequestMapping("/logout")
  public @ResponseBody ResponseEntity<String> getById(@RequestHeader("sessionid") String sessionId) {
      sessionData.removeSession(sessionId);
      return new ResponseEntity(HttpStatus.ACCEPTED);
  }


}
