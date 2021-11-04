package com.gestionhotelera.cammons.habitaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ImagenesHabitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnoreProperties(value = {"imagenes"})
    @JoinColumn(name = "id_habitacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Habitaciones habitaciones;


    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @JsonIgnore
    private byte[] imagen;

    public Integer getImagenHashCode(){
        return (this.imagen != null) ? this.imagen.hashCode() : null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHabitaciones(Habitaciones habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public Long getId() {
        return id;
    }

    public Habitaciones getHabitaciones() {
        return habitaciones;
    }
}
