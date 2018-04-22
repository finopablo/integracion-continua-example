package com.utn.progav2.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pablo on 02/11/16.
 */
public class LoginResponseWrapper {

    @JsonProperty
    private String sessionId;


    public LoginResponseWrapper() {

    }

    public LoginResponseWrapper(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
