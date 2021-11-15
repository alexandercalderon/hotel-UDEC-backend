package com.modulo1.security.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String nombre;
	private String segundoNombre;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String nombre, String segundoNombre, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.segundoNombre = segundoNombre;
		this.email = email;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}
}
