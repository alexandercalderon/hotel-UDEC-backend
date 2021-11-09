package com.gestionhotelera.api.app.checkin.microservicecheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 7/11/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCheckInDTO {

    @NotNull
    private Integer numeroDias;
    @NotNull
    private LocalDate fechaIngreso;
    @NotNull
    private LocalDate fechaSalida;
    @NotNull
    private Long identificadorPersona;
    @NotNull
    private List<HabitacionDTO> habitaciones;


}
