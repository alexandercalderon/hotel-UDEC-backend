package com.gestionhotelera.api.app.ocupacion.repository;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.TipoHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.habitaciones;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ITipoHabitacionesRepo extends JpaRepository<TipoHabitacion, Long> {
    @Query("Select h from habitaciones h join fetch h.tipoHabitacion th where h.idHabitacion=?1")
    public Optional<habitaciones> findByTipoHabitacion(Long id);
}
