package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.api.app.checkout.repository.IPersonaRepo;
import com.gestionhotelera.api.app.checkout.repository.IVentasRepo;
import com.gestionhotelera.cammons.habitaciones.model.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IVentasServiceImpl implements IVentaService{

    @Autowired
    private IVentasRepo repo;

    @Override
    public Ventas save(Ventas ventas) {
        return repo.save(ventas);
    }

    @Override
    public Ventas find(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
