package com.gestionhotelera.api.app.ocupacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan({"com.gestionhotelera.cammons.habitaciones.model"})
public class MicroservicioOcupacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioOcupacionApplication.class, args);
    }

}
