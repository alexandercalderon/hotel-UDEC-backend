package com.gestionhotelera.api.app.checkin.microservicecheckin.service;

import com.gestionhotelera.cammons.habitaciones.model.Habitacion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
@Repository
public interface IHabitacionService {

    List<Habitacion> getAllHabitaciones();

    Habitacion findByNumHabitacion(Integer numeroHab);

    void saveHabitacion(Habitacion habitacion);
}
