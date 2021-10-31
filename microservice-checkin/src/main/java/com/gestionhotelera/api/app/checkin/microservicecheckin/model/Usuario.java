package com.gestionhotelera.api.app.checkin.microservicecheckin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String cedula;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String direccion;

    @NotBlank
    private String ciudad;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefono;

    @ManyToMany(fetch =  FetchType.LAZY)
    @JoinTable(name = "usuarios_habitaciones", joinColumns = @JoinColumn(name = "usuario_id")
            ,inverseJoinColumns = @JoinColumn(name = "habitacion_id")
            ,uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id","habitacion_id"})})
    private Set<Habitacion> habitaciones;

}
