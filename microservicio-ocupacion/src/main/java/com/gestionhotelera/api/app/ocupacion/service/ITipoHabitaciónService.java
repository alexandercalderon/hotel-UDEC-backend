package com.gestionhotelera.api.app.ocupacion.service;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.TipoHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.habitaciones;

import java.util.List;

public interface ITipoHabitaciónService {
    public List<TipoHabitacion> list();
    public ImagenesHabitacion find(Long id_habitacion, Long id_imagen);
    public TipoHabitacion find(Long id);
    public habitaciones findHabitaciones(Long id);
    public TipoHabitacion save(TipoHabitacion tipoHabitacion);
    public List<TipoHabitacion> filtrado(Character estado);
}
