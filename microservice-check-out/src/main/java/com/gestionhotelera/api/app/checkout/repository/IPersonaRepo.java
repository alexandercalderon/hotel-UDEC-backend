package com.gestionhotelera.api.app.checkout.repository;

import com.gestionhotelera.cammons.habitaciones.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonaRepo extends JpaRepository<Personas, Integer> {
}
