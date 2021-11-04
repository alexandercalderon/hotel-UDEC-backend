package com.gestionhotelera.api.app.checkout.repository;

import com.gestionhotelera.cammons.habitaciones.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICheckOutRepo extends JpaRepository<CheckOut, Long> {
}
