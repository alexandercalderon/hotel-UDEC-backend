package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.cammons.habitaciones.model.Ventas;

public interface IVentaService {
    public Ventas save(Ventas ventas);
    public Ventas find(Integer id);
}
