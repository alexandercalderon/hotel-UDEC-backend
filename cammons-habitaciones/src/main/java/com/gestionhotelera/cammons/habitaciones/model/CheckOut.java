package com.gestionhotelera.cammons.habitaciones.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "check_out")
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @JsonIgnoreProperties(value = {"checkout"},allowSetters = true)
    @OneToMany(mappedBy = "checkout", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Adeudo> adeudos;

    @OneToOne
    @JoinColumn(name = "fk_persona", updatable = false, nullable = false)
    private Persona persona;

    public void setId(Long id) {
        this.id = id;
    }

    public void setHabitaciones(List<Habitaciones> habitaciones) {
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

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public List<Habitaciones> getHabitaciones() {
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

    public Persona getPersona() {
        return persona;
    }
}
