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

}
