package com.gestionhotelera.api.app.checkin.microservicecheckin.service.implementation;

import com.gestionhotelera.api.app.checkin.microservicecheckin.repository.PersonaRepository;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IPersonaService;
import com.gestionhotelera.cammons.habitaciones.model.Personas;
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
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Personas> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Personas getPersonaByIdentificacion(String identificacion) {
        return personaRepository.findByIdentificacion(identificacion);
    }
    @Override
    public Personas getPersonaById(Long id) {
        return personaRepository.getById(id);
    }

    @Override
    public void savePersona(Personas persona) {
        personaRepository.save(persona);
    }
}
