package com.gestionhotelera.api.app.ocupacion.service;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.TipoHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.habitaciones;
import com.gestionhotelera.api.app.ocupacion.repository.IHabitacionseRepo;
import com.gestionhotelera.api.app.ocupacion.repository.ITipoHabitacionesRepo;
import com.gestionhotelera.api.app.ocupacion.repository.ImagenesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ITipoHabitacionServiceImpl implements ITipoHabitaciónService{

    @Autowired
    private ITipoHabitacionesRepo repo;

    @Autowired
    private ImagenesRepo imagenesRepo;

    @Autowired
    private IHabitacionseRepo habitacionseRepo;


    @Override
    public List<TipoHabitacion> list() {
        return repo.findAll();
    }

    @Override
    public ImagenesHabitacion find(Long id_habitacion, Long id_imagen) {
       return imagenesRepo.findImageByHabitacion(id_habitacion, id_imagen).orElse(null);
    }

    @Override
    public habitaciones find(Long id) {
        return habitacionseRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public habitaciones save(habitaciones habitaciones) {
        return habitacionseRepo.save(habitaciones);
    }

}
