package com.gestionhotelera.api.app.checkin.microservicecheckin.repository;

import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author jhonc
 * @version 1.0
 * @since 7/11/2021
 */
@Repository
public interface HabitacionRepository extends JpaRepository<Habitaciones, Long> {


    @Query("select h from Habitaciones h left join fetch h.tipoHabitacion t left join fetch h.imagenes i where h.numHabitacion=?1")
    Habitaciones getHabitacionWithAll(Long numHabitacion);

}
