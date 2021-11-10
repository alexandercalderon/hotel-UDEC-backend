package com.gestionhotelera.api.app.ocupacion.repository;

import com.gestionhotelera.cammons.habitaciones.model.ImagenesHabitacion;
import com.gestionhotelera.cammons.habitaciones.model.TipoHabitacion;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ITipoHabitacionesRepo extends JpaRepository<TipoHabitacion, Long> {

    @Query("select  i from ImagenesHabitacion  i join  fetch  i.habitaciones h where h.idHabitacion=?1 and  i.id=?2")
    public Optional<ImagenesHabitacion> findImageByHabitacion(Long id_habitación, Long id_imagen);

    @Query("select  h from Habitaciones  h join fetch  h.tipoHabitacion th where h.idHabitacion=?1")
    public Optional<Habitaciones> findHabitaciones(Long idHanitacion);

    @Query("select th from TipoHabitacion th join fetch th.habitaciones h where h.estado=?1")
    public List<TipoHabitacion> filtrar(Character estado);

    @Query("select h from Habitaciones h join fetch h.tipoHabitacion th where h.numHabitacion=?1")
    public Habitaciones findByNumHabitacion(Long numHabitacion);
}
