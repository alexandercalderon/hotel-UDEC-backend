package com.gestionhotelera.api.app.ocupacion.service;

import com.gestionhotelera.cammons.habitaciones.model.ImagenesHabitacion;
import com.gestionhotelera.cammons.habitaciones.model.TipoHabitacion;
import com.gestionhotelera.cammons.habitaciones.model.habitaciones;
import com.gestionhotelera.api.app.ocupacion.repository.ITipoHabitacionesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ITipoHabitacionServiceImpl implements ITipoHabitaciónService{

    @Autowired
    private ITipoHabitacionesRepo repo;


    @Override
    @Transactional(readOnly = true)
    public List<TipoHabitacion> list() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ImagenesHabitacion find(Long id_habitacion, Long id_imagen) {
       return repo.findImageByHabitacion(id_habitacion, id_imagen).orElse(null);
    }

    @Query
    @Transactional(readOnly = true)
    @Override
    public TipoHabitacion find(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public habitaciones findHabitaciones(Long id) {
        return repo.findHabitaciones(id).orElse(null);
    }

    @Override
    @Transactional
    public TipoHabitacion save(TipoHabitacion tipoHabitacion) {
        return repo.save(tipoHabitacion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoHabitacion> filtrado(Character estado) {
        return repo.filtrar(estado);
    }


}
