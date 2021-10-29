package com.gestionhotelera.api.app.checkin.microservicecheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author jhonc
 * @version 1.0
 * @since 29/10/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInDTO {

    private Long id;

    private Integer numeroDias;

    private LocalDate fechaIngreso;

    private LocalDate fechaSalida;

    private Long idUsuario;

}
