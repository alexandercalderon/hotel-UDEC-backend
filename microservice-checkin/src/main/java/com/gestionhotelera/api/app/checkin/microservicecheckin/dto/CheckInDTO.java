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
public class CheckInDTO {

    private Long id;
    private Integer numeroDias;
    private String fechaIngreso;
    private String fechaSalida;
    private UsuarioDTO usuario;

}
