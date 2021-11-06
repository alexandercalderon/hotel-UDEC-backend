package com.gestionhotelera.api.app.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan({"com.gestionhotelera.cammons.habitaciones.model"})
public class MicroserviceCheckOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCheckOutApplication.class, args);
    }

}
