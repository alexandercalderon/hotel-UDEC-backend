package com.gestionhotelera.cammons.habitaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    @Column(name = "num_habitacion")
    private Long numHabitacion;

    private Character estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_habitacion")
    @JsonIgnoreProperties(value = {"habitaciones","hibernateLazyInitializer", "handler"})
    private TipoHabitacion tipoHabitacion;


    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "habitaciones"}, allowSetters = true)
    @OneToMany(mappedBy = "habitaciones", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ImagenesHabitacion> imagenes;

    @JsonIgnore
    @ManyToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    private List<CheckOut> checkouts;

    @JsonIgnore
    @ManyToMany(mappedBy = "habitacionCheckIn", cascade = CascadeType.ALL)
    private List<CheckIn> checkIns;




    //TODO: GETTERS an SETTERS



    public void setCheckouts(List<CheckOut> checkouts) {
        this.checkouts = checkouts;
    }
    public void addCheckouts(CheckOut checkOut){
        this.checkouts.add(checkOut);
    }

    public List<CheckOut> getCheckouts() {
        return checkouts;
    }

    public Habitaciones() {
        this.imagenes = new ArrayList<>();
        this.checkouts = new ArrayList<>();
    }

    public List<ImagenesHabitacion> getImagenes() {
        return imagenes;
    }


    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public Long getNumHabitacion() {
        return numHabitacion;
    }

    public Character getEstado() {
        return estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setNumHabitacion(Long numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setImagenes(List<ImagenesHabitacion> imagenes) {
        this.imagenes = imagenes;
    }
    public void addImagen(ImagenesHabitacion imagenesHabitacion){
        this.imagenes.add(imagenesHabitacion);
        imagenesHabitacion.setHabitaciones(this);
    }

    public List<CheckIn> getCheckIns() {
        return checkIns;
    }

    public void setCheckIns(List<CheckIn> checkIns) {
        this.checkIns = checkIns;
    }

}
