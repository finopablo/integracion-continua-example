package com.utn.progav2.util;

import com.utn.progav2.entities.Usuario;
import org.hibernate.id.GUIDGenerator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by pablo on 01/11/16.
 */
@Service
public class SessionData {


    HashMap<String, AuthenticationData> sessionData;

    @Value("${session.expiration}")
    int expirationTime;


    public SessionData() {
        this.sessionData = new HashMap<String, AuthenticationData>();
    }

    public String addSession(Usuario usuario) {
        String sessionId = UUID.randomUUID().toString();
        AuthenticationData aData = new AuthenticationData();
        aData.setUsuario(usuario);
        aData.setLastAction(new DateTime());
        this.sessionData.put(sessionId, aData);
        return sessionId;
    }


    public void removeSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public AuthenticationData getSession(String sessionId) {
        AuthenticationData aData = this.sessionData.get(sessionId);
        if (aData != null) {
            if (aData.getLastAction().plusSeconds(expirationTime).isBefore(System.currentTimeMillis())) {
                sessionData.remove(sessionId);
                return null;
            } else {
                return aData;
            }
        } else {
            return null;
        }
    }

}
