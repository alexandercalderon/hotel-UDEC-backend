package com.gestionhotelera.api.app.ocupacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    @Column(name = "num_habitacion")
    private Long numHabitacion;

    private Character estado;


    @JsonIgnoreProperties(value = "habitaciones")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_habitacion")
    private TipoHabitacion tipoHabitacion;


    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "habitaciones"}, allowSetters = true)
    @OneToMany(mappedBy = "habitaciones", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ImagenesHabitacion> imagenes;

    public void setImagenes(List<ImagenesHabitacion> imagenes) {
        this.imagenes = imagenes;
    }
    public void addImagen(ImagenesHabitacion imagenesHabitacion){
        this.imagenes.add(imagenesHabitacion);
        imagenesHabitacion.setHabitaciones(this);
    }

    public habitaciones() {
        this.imagenes = new ArrayList<>();
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
}
