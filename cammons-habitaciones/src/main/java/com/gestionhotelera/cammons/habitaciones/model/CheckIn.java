package com.gestionhotelera.cammons.habitaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */

@Entity
@Table(name = "check_in")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer numeroDias;

    @NotNull
    private LocalDate fechaIngreso;

    @NotNull
    private LocalDate fechaSalida;

    @OneToOne
    @JoinColumn(name = "id_persona", updatable = false, nullable = false)
    private Personas persona;

    @JoinTable(
            name = "checkin_habitaciones",
            joinColumns = @JoinColumn(name = "id_checkin",nullable = false ),
            inverseJoinColumns = @JoinColumn(name = "id_habitacion", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Habitaciones> habitacionCheckIn;

}
