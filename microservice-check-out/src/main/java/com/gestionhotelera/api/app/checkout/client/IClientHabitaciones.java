package com.gestionhotelera.api.app.checkout.client;

import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-ocupacion", url = "localhost:8003")
public interface IClientHabitaciones {
    @GetMapping("/find/{id}")
    public Habitaciones find(@PathVariable Long id);
}
