package com.gestionhotelera.api.app.checkin.microservicecheckin.repository;

import com.gestionhotelera.cammons.habitaciones.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion,Long> {

    Habitacion findByNumeroHabitacion(Integer numeroHabitacion);

}
