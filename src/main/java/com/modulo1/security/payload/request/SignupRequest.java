package com.modulo1.security.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String nombre;

    @Null
    @Size(min = 3, max = 20)
    private String segundoNombre;

    @NotBlank
    @Size(min = 3, max = 20)
    private String apellido;

    @Null
    @Size(min = 3, max = 20)
    private String segundoApellido;

    @NotBlank
    @Size(max = 10)
    private String identificacion;

    @NotBlank
    @Size(max = 12)
    private String telefono;

    @NotBlank
    @Size(min = 1, max = 150)
    private String razonSocial;

    @NotBlank
    @Size(min = 10, max = 50)
    private String direccion;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getsegundoNombre() {
        return segundoNombre;
    }

    public void setsegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getsegundoApellido() {
        return segundoApellido;
    }

    public void setsegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getrazonSocial() {
        return razonSocial;
    }

    public void setrazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
      return this.role;
    }

    public void setRole(Set<String> role) {
      this.role = role;
    }
}
