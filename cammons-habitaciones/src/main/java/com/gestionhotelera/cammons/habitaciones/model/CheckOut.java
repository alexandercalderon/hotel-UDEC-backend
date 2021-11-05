package com.gestionhotelera.cammons.habitaciones.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "check_out")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties(value = {"checkouts", "imagenes"}, allowSetters = true)
    @JoinTable(
            name = "checkout_habitaciones",
            joinColumns = @JoinColumn(name = "fk_check_out",nullable = false ),
            inverseJoinColumns = @JoinColumn(name = "fk_habitaciones", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Habitaciones> habitacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_egreso")
    private Date fechaEgreso;

    @Column(name = "numero_dias")
    private Integer numeroDias;

    @JsonIgnoreProperties(value = {"checkOut"},allowSetters = true)
    @OneToMany(mappedBy = "checkout", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Adeudo> adeudos;


    @OneToOne
    @JsonIgnoreProperties(value = {"checkOut"}, allowSetters = true)
    @JoinColumn(name = "fk_persona", updatable = false, nullable = false)
    private Personas persona;

    @OneToOne
    @JsonIgnoreProperties(value = {"checkOut"}, allowSetters = true)
    @JoinColumn(name = "fk_venta", updatable = false, nullable = false)
    private Ventas ventas;

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHabitacion(List<Habitaciones> habitaciones) {
        this.habitacion = habitaciones;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public void setNumeroDias(Integer numeroDias) {
        this.numeroDias = numeroDias;
    }

    public void setAdeudos(List<Adeudo> adeudos) {
        this.adeudos = adeudos;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public List<Habitaciones> getHabitacion() {
        return habitacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public Integer getNumeroDias() {
        return numeroDias;
    }

    public List<Adeudo> getAdeudos() {
        return adeudos;
    }

    public Personas getPersona() {
        return persona;
    }
}
