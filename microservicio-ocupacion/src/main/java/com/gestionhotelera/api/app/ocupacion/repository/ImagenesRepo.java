package com.gestionhotelera.api.app.ocupacion.repository;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ImagenesRepo extends JpaRepository<ImagenesHabitacion, Long> {

    @Query("select  i from ImagenesHabitacion  i join  fetch  i.habitaciones h where h.idHabitacion=?1 and  i.id=?2")
    public Optional<ImagenesHabitacion> findImageByHabitacion(Long id_habitación, Long id_imagen);

}
