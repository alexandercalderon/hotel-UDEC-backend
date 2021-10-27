package com.gestionhotelera.api.app.ocupacion.repository;

import com.gestionhotelera.api.app.ocupacion.model.habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHabitacionseRepo extends JpaRepository<habitaciones,Long> {
}
