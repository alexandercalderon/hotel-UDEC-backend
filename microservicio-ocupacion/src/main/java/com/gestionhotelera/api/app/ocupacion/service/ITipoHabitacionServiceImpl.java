package com.gestionhotelera.api.app.ocupacion.service;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.TipoHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.habitaciones;
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
    @Transactional
    @Override
    public TipoHabitacion find(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public habitaciones findHabitaciones(Long id) {
        return repo.findHabitaciones(id).orElse(null);
    }

    @Override
    public TipoHabitacion save(TipoHabitacion tipoHabitacion) {
        return repo.save(tipoHabitacion);
    }


}
