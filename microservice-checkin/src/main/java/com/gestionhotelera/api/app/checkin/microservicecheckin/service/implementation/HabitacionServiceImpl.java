package com.gestionhotelera.api.app.checkin.microservicecheckin.service.implementation;

import com.gestionhotelera.api.app.checkin.microservicecheckin.model.Habitacion;
import com.gestionhotelera.api.app.checkin.microservicecheckin.repository.HabitacionRepository;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
@Service
@Transactional
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public List<Habitacion> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    @Override
    public Habitacion findByNumHabitacion(Integer numeroHab) {
        return habitacionRepository.findByNumeroHabitacion(numeroHab);
    }

    @Override
    public void saveHabitacion(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }
}
