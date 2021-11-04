package com.gestionhotelera.api.app.checkin.microservicecheckin.service;


import com.gestionhotelera.cammons.habitaciones.model.Persona;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
public interface IPersonaService {

    List<Persona> getAllPersonas();

    Persona getPersonaByIdentificacion(String identificacion);

    Persona getPersonaById(Long id);

    void savePersona(Persona persona);
}
