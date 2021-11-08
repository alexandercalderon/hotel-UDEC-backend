package com.gestionhotelera.api.app.checkin.microservicecheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Integer numeroDias;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Long identificadorPersona;
    private List<HabitacionDTO> habitaciones;


}
