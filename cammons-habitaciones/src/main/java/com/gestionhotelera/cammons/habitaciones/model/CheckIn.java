package com.gestionhotelera.cammons.habitaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
    @PrimaryKeyJoinColumn
    private Usuario usuario;

}
