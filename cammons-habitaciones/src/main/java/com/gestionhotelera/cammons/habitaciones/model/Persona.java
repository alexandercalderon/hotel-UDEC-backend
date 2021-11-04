package com.gestionhotelera.cammons.habitaciones.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

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

    private String direccion;

    private String telefono;

    private String correo;

    @Column(unique = true)
    private Long identificacion;

    @NotNull
    private Character genero;

    @OneToOne(mappedBy = "persona",cascade = CascadeType.ALL )
    private CheckOut checkOut;

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void setPriNombre(String priNombre) {
        this.priNombre = priNombre;
    }

    public void setSegNombre(String segNombre) {
        this.segNombre = segNombre;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public void setSegApellido(String segApellido) {
        this.segApellido = segApellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public String getPriNombre() {
        return priNombre;
    }

    public String getSegNombre() {
        return segNombre;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public String getSegApellido() {
        return segApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public Character getGenero() {
        return genero;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }
}
