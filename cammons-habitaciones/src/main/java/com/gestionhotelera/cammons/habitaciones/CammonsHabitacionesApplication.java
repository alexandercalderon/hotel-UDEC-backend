package com.gestionhotelera.cammons.habitaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CammonsHabitacionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CammonsHabitacionesApplication.class, args);
    }

}
