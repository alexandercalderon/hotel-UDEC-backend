package com.gestionhotelera.api.app.checkout.repository;

import com.gestionhotelera.cammons.habitaciones.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IVentasRepo extends JpaRepository<Ventas, Integer> {
}
