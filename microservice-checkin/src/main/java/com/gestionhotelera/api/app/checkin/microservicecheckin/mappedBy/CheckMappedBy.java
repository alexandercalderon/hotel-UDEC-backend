package com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.CheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.HabitacionDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.UsuarioDTO;
import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import com.gestionhotelera.cammons.habitaciones.model.Personas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jhonc
 * @version 1.0
 * @since 5/11/2021
 */
public class CheckMappedBy {

    private CheckInDTO checkInDTO;

    public CheckMappedBy(){
        checkInDTO = new CheckInDTO();
    }

    public CheckInDTO checkInToCheckInDTO(CheckIn checkIn){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Personas persona = new Personas();
        List<HabitacionDTO> habitacionesList = new ArrayList<>();

        //CheckIn
        checkInDTO.setId(checkIn.getId());
        checkInDTO.setNumeroDias(checkIn.getNumeroDias());
        checkInDTO.setFechaIngreso(String.valueOf(checkIn.getFechaIngreso()));
        checkInDTO.setFechaSalida(String.valueOf(checkIn.getFechaSalida()));

        persona = checkIn.getPersona();

        //Usuario
        usuarioDTO.setId(Long.valueOf(persona.getIdPersona()));
        usuarioDTO.setCedula(String.valueOf(persona.getIdentificacion()));
        usuarioDTO.setNombre(persona.getPriNombre()+ " " + persona.getSegNombre());
        usuarioDTO.setApellido(persona.getPriApellido()+ " " + persona.getSegApellido());
        usuarioDTO.setDireccion(persona.getDireccion());
        usuarioDTO.setEmail(persona.getCorreo());
        usuarioDTO.setTelefono(persona.getTelefono());
        if(String.valueOf(persona.getGenero()).equals("M")){
            usuarioDTO.setGenero("MASCULINO");
        }else if(String.valueOf(persona.getGenero()).equals("F")){
            usuarioDTO.setGenero("FEMENINO");
        }else{
            usuarioDTO.setGenero("");
        }
        //Habitaciones
        for(Habitaciones h : checkIn.getHabitacionCheckIn()){
            habitacionesList.add(new HabitacionDTO(h.getNumHabitacion()
                    , h.getTipoHabitacion().getNomTipoHabitacion()
                    , h.getTipoHabitacion().getPrecioHabitacion()));
        }
        usuarioDTO.setHabitaciones(habitacionesList);
        checkInDTO.setUsuario(usuarioDTO);
        return checkInDTO;
    }

}
