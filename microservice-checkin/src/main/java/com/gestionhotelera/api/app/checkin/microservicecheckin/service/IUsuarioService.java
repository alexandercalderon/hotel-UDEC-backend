package com.gestionhotelera.api.app.checkin.microservicecheckin.service;

import com.gestionhotelera.api.app.checkin.microservicecheckin.model.Usuario;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioByCedula(String cedula);

    Usuario getUsuarioById(Long id);

    void saveUsuario(Usuario usuario);
}
