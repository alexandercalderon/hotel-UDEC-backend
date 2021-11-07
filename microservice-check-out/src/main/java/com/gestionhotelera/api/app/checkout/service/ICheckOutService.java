package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.cammons.habitaciones.model.CheckOut;

import java.util.List;

public interface ICheckOutService {
    public List<CheckOut> list();
    public CheckOut save(CheckOut checkOut);
    public CheckOut find(Long id);
    public CheckOut findByIdentificacion(Long dentificacion);
}
