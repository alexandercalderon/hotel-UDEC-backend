package com.gestionhotelera.api.app.checkin.microservicecheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jhonc
 * @version 1.0
 * @since 5/11/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDTO {

    private Long numeroHabitacion;
    private String tipo;
    private Long tarifa;

}
