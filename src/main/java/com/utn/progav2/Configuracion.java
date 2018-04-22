package com.utn.progav2;

import com.utn.progav2.converter.PersonaConverter;
import com.utn.progav2.converter.PersonaConverterInterface;
import com.utn.progav2.converter.PersonaUglyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pablo on 12/10/16.
 */
@Configuration
public class Configuracion {

    @Autowired
    private AuthFilter authFilter;

    @Value("${date.format}")
    private String dateFormat;

    @Bean(name = "normalConverter")
    public PersonaConverterInterface getNormalConverter() {
        return  new PersonaConverter(dateFormat);

    }

    @Bean(name = "uglyConverter")
    public PersonaConverterInterface getUglyConverter() {
        return new PersonaUglyConverter(dateFormat);

    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

    public AuthFilter getAuthFilter() {
        return authFilter;
    }

    public void setAuthFilter(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
