package com.gestionhotelera.api.app.checkin.microservicecheckin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
