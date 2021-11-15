package com.modulo1.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.modulo1.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String segundoNombre;

    private String apellido;

	private String segundoApellido;

	private String identificacion;

	private String telefono;

	private String razonSocial;

	private String direccion;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String nombre, String segundoNombre, String apellido, String segundoApellido, String identificacion, String telefono, String razonSocial, String direccion, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
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
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(),
				user.getNombre(),
				user.getsegundoNombre(),
                user.getApellido(),
				user.getsegundoApellido(),
				user.getIdentificacion(),
				user.getTelefono(),
				user.getrazonSocial(),
				user.getDireccion(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

    // @Override
	public String getNombre() {
		return nombre;
	}

    // @Override
	public String getsegundoNombre() {
		return segundoNombre;
	}

    // @Override
	public String getApellido() {
		return apellido;
	}

    // @Override
	public String getsegundoApellido() {
		return segundoApellido;
	}

    // @Override
	public String getIdentificacion() {
		return identificacion;
	}

    // @Override
	public String getTelefono() {
		return telefono;
	}

    // @Override
	public String getrazonSocial() {
		return razonSocial;
	}

    // @Override
	public String getDireccion() {
		return direccion;
	}

    @Override
	public String getUsername() {
		return username;
	}

    public String getEmail() {
		return email;
	}

    @Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
