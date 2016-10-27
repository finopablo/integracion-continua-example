package com.utn.progav2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by pablo on 20/09/16.
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer {


  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Main.class);
  }
}
