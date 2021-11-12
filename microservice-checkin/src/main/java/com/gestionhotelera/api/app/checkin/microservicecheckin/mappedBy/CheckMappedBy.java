package com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.*;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.ICheckInService;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IHabitacionService;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IPersonaService;
import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import com.gestionhotelera.cammons.habitaciones.model.Personas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jhonc
 * @version 1.0
 * @since 5/11/2021
 */
@Component
@Transactional
public class CheckMappedBy {


    private CheckInDTO checkInDTO;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IHabitacionService habitacionService;

    @Autowired
    private ICheckInService checkInService;


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


    public ResponseEntity<?> getHabitacionByNumHabitacion(Long numHabitacion){
        Map<String, Object> response = new HashMap<>();
        HabitacionDTO habitacionDTO = new HabitacionDTO();
        CheckIn checkIn = null;
        Habitaciones habitacion = null;

        try{
            habitacion = habitacionService.getHabitacionByNumeroHabitacion(numHabitacion);
            if(habitacion == null){
                response.put("mensaje","La habitacon ["+numHabitacion+"] no existe");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            //Como saber is una habitacion ya esta asociada aun check-in
            checkIn = checkInService.checkByNumeroHabitacion(habitacion.getNumHabitacion());
            if(checkIn != null){
                response.put("mensaje","Esta habitacion ya tiene asociado un Check-in");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            habitacionDTO.setNumeroHabitacion(habitacion.getNumHabitacion());
            habitacionDTO.setTipo(habitacion.getTipoHabitacion().getNomTipoHabitacion());
            habitacionDTO.setTarifa(habitacion.getTipoHabitacion().getPrecioHabitacion());
        }catch (DataAccessException e){
            response.put("mensaje", "Error al a buscar la habitacion");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("habitacionDTO",habitacionDTO);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
