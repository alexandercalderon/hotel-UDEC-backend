package com.gestionhotelera.api.app.checkin.microservicecheckin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.gestionhotelera.cammons.habitaciones.model"})
public class MicroserviceCheckinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCheckinApplication.class, args);
	}

}
