package com.gestionhotelera.api.app.checkin.microservicecheckin.service.implementation;

import com.gestionhotelera.api.app.checkin.microservicecheckin.repository.HabitacionRepository;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IHabitacionService;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jhonc
 * @version 1.0
 * @since 7/11/2021
 */
@Service
@Transactional
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public Habitaciones getHabitacionByNumeroHabitacion(Long numHabitacion) {
        return habitacionRepository.getHabitacionWithAll(numHabitacion);
    }
}
