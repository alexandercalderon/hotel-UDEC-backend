package com.gestionhotelera.api.app.checkin.microservicecheckin.service.implementation;

import com.gestionhotelera.api.app.checkin.microservicecheckin.repository.UsuarioRepository;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IUsuarioService;
import com.gestionhotelera.cammons.habitaciones.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioByCedula(String cedula) {
        return usuarioRepository.findByCedula(cedula);
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.getById(id);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
