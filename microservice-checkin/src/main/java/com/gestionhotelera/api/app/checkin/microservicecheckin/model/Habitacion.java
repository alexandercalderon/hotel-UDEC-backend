package com.gestionhotelera.api.app.checkin.microservicecheckin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */

@Entity
@Table(name = "habitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;

    private Integer numeroHabitacion;

    private Double tarifa;

}
