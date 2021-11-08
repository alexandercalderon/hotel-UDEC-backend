package com.gestionhotelera.api.app.checkin.microservicecheckin.service;


import com.gestionhotelera.cammons.habitaciones.model.Personas;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
public interface IPersonaService {

    List<Personas> getAllPersonas();

    Personas getPersonaByIdentificacion(Long identificacion);

    Personas getPersonaById(Long id);

    void savePersona(Personas persona);
}
