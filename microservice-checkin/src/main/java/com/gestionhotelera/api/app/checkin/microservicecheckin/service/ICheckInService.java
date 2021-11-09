package com.gestionhotelera.api.app.checkin.microservicecheckin.service;


import com.gestionhotelera.cammons.habitaciones.model.CheckIn;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
public interface ICheckInService {

    List<CheckIn> getAllChechIn();

    CheckIn getCheckInById(Long id);

    void saveCheckIn(CheckIn checkIn);

    CheckIn getCheckInOf(Long id);

    CheckIn getCheckByIdentificacion(Long identificacion);

    void deleteCheckInById(Long id);

}
