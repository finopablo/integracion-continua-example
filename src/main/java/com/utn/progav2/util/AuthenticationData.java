package com.utn.progav2.util;

import com.utn.progav2.entities.Usuario;
import org.joda.time.DateTime;

/**
 * Created by pablo on 01/11/16.
 */
public class AuthenticationData {

    private Usuario usuario;
    private DateTime lastAction;

    public DateTime getLastAction() {
        return lastAction;
    }

    public void setLastAction(DateTime lastAction) {
        this.lastAction = lastAction;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
