package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.api.app.checkout.repository.IPersonaRepo;
import com.gestionhotelera.cammons.habitaciones.model.Personas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IpersonaServiceImpl implements IpersonService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    public Personas save(Personas personas) {
        return repo.save(personas);
    }

    @Override
    public Personas find(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
