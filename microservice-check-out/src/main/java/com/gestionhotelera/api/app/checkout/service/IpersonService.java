package com.gestionhotelera.api.app.checkout.service;

import com.gestionhotelera.cammons.habitaciones.model.Personas;

import javax.persistence.criteria.CriteriaBuilder;

public interface IpersonService {
    public Personas save(Personas personas);
    public Personas find(Integer id);
    public Personas findByCedula(Long cedula);
}
