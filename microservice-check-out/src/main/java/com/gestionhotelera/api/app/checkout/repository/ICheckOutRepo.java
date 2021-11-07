package com.gestionhotelera.api.app.checkout.repository;

import com.gestionhotelera.cammons.habitaciones.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICheckOutRepo extends JpaRepository<CheckOut, Long> {

    @Query("select c from CheckOut c where  c.persona.identificacion=?1")
    public CheckOut findbyIdentifiacion(Long identificacion);

}
