package com.gestionhotelera.api.app.ocupacion.service;

import com.gestionhotelera.cammons.habitaciones.model.ImagenesHabitacion;
import com.gestionhotelera.cammons.habitaciones.model.TipoHabitacion;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;

import java.util.List;

public interface ITipoHabitaciónService {
    public List<TipoHabitacion> list();
    public ImagenesHabitacion find(Long id_habitacion, Long id_imagen);
    public TipoHabitacion find(Long id);
    public Habitaciones findHabitaciones(Long id);
    public TipoHabitacion save(TipoHabitacion tipoHabitacion);
    public List<TipoHabitacion> filtrado(Character estado);
}
