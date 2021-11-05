package com.gestionhotelera.api.app.checkin.microservicecheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 5/11/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;
    private String genero;
    private List<HabitacionDTO> habitaciones;


}
