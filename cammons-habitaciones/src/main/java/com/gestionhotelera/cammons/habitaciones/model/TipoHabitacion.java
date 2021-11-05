package com.gestionhotelera.cammons.habitaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion")
    private  Long idTipoHabitacion;

    @Column(name = "nom_tipo_habitacion")
    private String nomTipoHabitacion;

    @Column(name = "desc_tipo_habitacion")
    private String descTipoHabitacion;

    @Column(name = "precio_habitacion")
    private Long precioHabitacion;

    public TipoHabitacion() {
        this.habitaciones = new ArrayList<>();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "tipoHabitacion", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Habitaciones> habitaciones;

    public void setIdTipoHabitacion(Long idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public void setNomTipoHabitacion(String nomTipoHabitacion) {
        this.nomTipoHabitacion = nomTipoHabitacion;
    }

    public void setDescTipoHabitacion(String descTipoHabitacion) {
        this.descTipoHabitacion = descTipoHabitacion;
    }

    public void setPrecioHabitacion(Long precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public void setHabitaciones(List<Habitaciones> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Long getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public String getNomTipoHabitacion() {
        return nomTipoHabitacion;
    }

    public String getDescTipoHabitacion() {
        return descTipoHabitacion;
    }

    public Long getPrecioHabitacion() {
        return precioHabitacion;
    }

    public List<Habitaciones> getHabitaciones() {
        return habitaciones;
    }
}
