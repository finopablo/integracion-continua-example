package com.utn.progav2;

import com.utn.progav2.converter.PersonaConverter;
import com.utn.progav2.converter.PersonaConverterInterface;
import com.utn.progav2.converter.PersonaUglyConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pablo on 12/10/16.
 */
@Configuration
public class Configuracion {


    @Value("${date.format}")
    String dateFormat;

    @Bean(name="normalConverter")
    public PersonaConverterInterface getNormalConverter(){
        return  new PersonaConverter(dateFormat);

    }

    @Bean(name="uglyConverter")
    public PersonaConverterInterface getUglyConverter() {
        return new PersonaUglyConverter(dateFormat);

    }

}
