package com.gestionhotelera.cammons.habitaciones.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(unique = true)
    private Long identificacion;

    @NotNull
    @Column(name = "pri_nombre")
    private String priNombre;

    @Column(name = "seg_nombre")
    private String segNombre;

    @NotNull
    @Column(name = "pri_apellido")
    private String priApellido;

    @Column(name = "seg_apellido")
    private String segApellido;

    private String correo;

    private String direccion;

    @NotNull
    private Character genero;

    private String telefono;
}
