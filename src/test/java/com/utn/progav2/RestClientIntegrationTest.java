package com.utn.progav2;

import com.utn.progav2.response.LoginResponseWrapper;
import com.utn.progav2.response.PersonaWrapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by pablo on 02/11/16.
 */
public class RestClientIntegrationTest extends TestCase
{

    RestTemplate restTemplate;

    @Test
    public void testLoginOk() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/login";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("user", "finopablo");
        params.set("pwd", "1234");
        ResponseEntity<LoginResponseWrapper> response = restTemplate.postForEntity(url, params, LoginResponseWrapper.class);
        assertNotNull(response.getBody().getSessionId());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void testGetPersona() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/login";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("user", "finopablo");
        params.set("pwd", "1234");


        ResponseEntity<LoginResponseWrapper> response = restTemplate.postForEntity(url, params, LoginResponseWrapper.class);
        String sessionId = response.getBody().getSessionId();


        HttpHeaders headers = new HttpHeaders();
        headers.set("sessionid", sessionId);
        HttpEntity entity = new HttpEntity(headers);

        url = "http://localhost:8090/api/persona/1";

        HttpEntity<PersonaWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, PersonaWrapper.class);

        PersonaWrapper p = responseEntity.getBody();

        assertEquals(p.getApellido(), "FUNES MORI");

    }







}
