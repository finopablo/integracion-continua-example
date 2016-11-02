package com.utn.progav2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by pablo on 20/09/16.
 */
@SpringBootApplication
@EnableScheduling
public class Main extends SpringBootServletInitializer {


  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Main.class);
  }
}
