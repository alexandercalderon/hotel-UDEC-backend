package com.gestionhotelera.api.app.ocupacion.repository;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.TipoHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ITipoHabitacionesRepo extends JpaRepository<TipoHabitacion, Long> {

    @Query("select  i from ImagenesHabitacion  i join  fetch  i.habitaciones h where h.idHabitacion=?1 and  i.id=?2")
    public Optional<ImagenesHabitacion> findImageByHabitacion(Long id_habitación, Long id_imagen);

    @Query("select  h from habitaciones  h join fetch  h.tipoHabitacion th where h.idHabitacion=?1")
    public Optional<habitaciones> findHabitaciones(Long idHanitacion);

    @Query("select h from habitaciones h  where h.estado=?1")
    public List<habitaciones> filtrar(Character estado);
}
