package com.gestionhotelera.api.app.checkin.microservicecheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jhonc
 * @version 1.0
 * @since 11/11/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinglePersonDTO {

    private Long cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;

}
