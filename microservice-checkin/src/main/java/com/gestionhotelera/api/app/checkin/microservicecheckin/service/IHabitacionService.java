package com.gestionhotelera.api.app.checkin.microservicecheckin.service;

import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;

/**
 * @author jhonc
 * @version 1.0
 * @since 7/11/2021
 */
public interface IHabitacionService {

    Habitaciones getHabitacionByNumeroHabitacion(Long numHabitacion);

}
