package com.utn.progav2;


import com.utn.progav2.util.AuthenticationData;
import com.utn.progav2.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Enumeration;
import java.util.Collections;

@Service
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private SessionData sessionData;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String sessionId = request.getHeader("sessionid");
        AuthenticationData data = sessionData.getSession(sessionId);
        if (null != data) {
            HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
            requestWrapper.addHeader("usuario", data.getUsuario().getNombreUsuario());
            filterChain.doFilter(requestWrapper, response);
        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }

    public SessionData getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }

    public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
        /**
         * construct a wrapper for this request
         *
         * @param request
         */
        public HeaderMapRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        private Map<String, String> headerMap = new HashMap<String, String>();

        /**
         * add a header with given name and value
         *
         * @param name
         * @param value
         */
        public void addHeader(String name, String value) {
            headerMap.put(name, value);
        }

        @Override
        public String getHeader(String name) {
            String headerValue = super.getHeader(name);
            if (headerMap.containsKey(name)) {
                headerValue = headerMap.get(name);
            }
            return headerValue;
        }

        /**
         * get the Header names
         */
        @Override
        public Enumeration<String> getHeaderNames() {
            List<String> names = Collections.list(super.getHeaderNames());
            for (String name : headerMap.keySet()) {
                names.add(name);
            }
            return Collections.enumeration(names);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            List<String> values = Collections.list(super.getHeaders(name));
            if (headerMap.containsKey(name)) {
                values.add(headerMap.get(name));
            }
            return Collections.enumeration(values);
        }

    }
}

