package com.gestionhotelera.cammons.habitaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Adeudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "servicio_habitacion")
    private String servicioHabitacion;

    @Column(name = "precio_unitario")
    private Long precioUnitario;

    private Long importe;


    @JsonIgnoreProperties(value = {"adeudos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_checkout")
    private CheckOut checkout;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkout = checkOut;
    }

    public CheckOut getCheckOut() {
        return checkout;
    }

    public void setServicioHabitacion(String servicioHabitacion) {
        this.servicioHabitacion = servicioHabitacion;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setImporte(Long importe) {
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public String getServicioHabitacion() {
        return servicioHabitacion;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public Long getImporte() {
        return importe;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Adeudo)) return false;
        Adeudo  adeudo= (Adeudo) obj;
        return this.id != null && this.id.equals(adeudo.getId());
    }
}
