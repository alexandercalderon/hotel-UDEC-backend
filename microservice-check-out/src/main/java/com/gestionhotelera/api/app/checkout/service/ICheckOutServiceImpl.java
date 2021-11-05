package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.api.app.checkout.repository.ICheckOutRepo;
import com.gestionhotelera.cammons.habitaciones.model.CheckOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICheckOutServiceImpl implements ICheckOutService{

    @Autowired
    private ICheckOutRepo checkOutRepo;

    @Override
    public List<CheckOut> list() {
        return checkOutRepo.findAll();
    }
}
