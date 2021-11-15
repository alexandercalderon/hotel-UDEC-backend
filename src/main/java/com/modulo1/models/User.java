package com.modulo1.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email"),
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	@Size(max = 20)
	private String identificacion;

    @NotBlank
	@Size(max = 20)
	private String telefono;

    @NotBlank
	@Size(min = 1, max = 150)
	private String razonSocial;

    @NotBlank
	@Size(min = 10, max = 50)
	private String direccion;

    @NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String nombre, String segundoNombre, String apellido, String segundoApellido, String identificacion, String telefono, String razonSocial, String direccion, String username, String email, String password) {
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.segundoApellido = segundoApellido;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
