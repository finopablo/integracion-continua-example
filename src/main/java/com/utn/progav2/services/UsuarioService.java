package com.utn.progav2.services;

import com.utn.progav2.entities.Usuario;
import com.utn.progav2.persistence.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by pablo on 01/11/16.
 */

@Service
public class UsuarioService {

    UsuarioDao usuarioDao;

    @Autowired
    public UsuarioService(UsuarioDao dao) {
        this.usuarioDao = dao;
    }

    public Usuario login(String nombreUsuario, String password) {
        return usuarioDao.get(nombreUsuario,password);
    }
}
