package com.gestionhotelera.api.app.checkin.microservicecheckin.service.implementation;

import com.gestionhotelera.api.app.checkin.microservicecheckin.repository.CheckInRepository;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.ICheckInService;
import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
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
public class CheckInServiceImpl implements ICheckInService {

    @Autowired
    private CheckInRepository checkInRepository;


    @Override
    public List<CheckIn> getAllChechIn() {
        return checkInRepository.findAll();
    }

    @Override
    public CheckIn getCheckInById(Long id) {
        return checkInRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCheckIn(CheckIn checkIn) {
        checkInRepository.save(checkIn);
    }

    @Override
    public CheckIn getCheckInOf(Long id) {
        return checkInRepository.getCheckInOf(id);
    }

    @Override
    public CheckIn getCheckByCedula(String cedula) {
        return checkInRepository.getCheckByCedulaOfUser(cedula);
    }


}
