package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.api.app.checkout.repository.ICheckOutRepo;
import com.gestionhotelera.cammons.habitaciones.model.CheckOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Temporal;
import java.util.List;

@Service
public class ICheckOutServiceImpl implements ICheckOutService{

    @Autowired
    private ICheckOutRepo checkOutRepo;

    @Override
    @Transactional(readOnly = true)
    public List<CheckOut> list() {
        return checkOutRepo.findAll();
    }

    @Override
    @Transactional
    public CheckOut save(CheckOut checkOut) {
        return checkOutRepo.save(checkOut);
    }

    @Override
    public CheckOut find(Long id) {
        return  checkOutRepo.findById(id).orElse(null);
    }

    @Override
    public CheckOut findByIdentificacion(Long dentificacion) {
        return checkOutRepo.findbyIdentifiacion(dentificacion);
    }
}
