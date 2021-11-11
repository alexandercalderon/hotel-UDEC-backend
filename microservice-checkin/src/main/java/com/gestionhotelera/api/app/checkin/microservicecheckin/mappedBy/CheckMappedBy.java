package com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.CheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.HabitacionDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.NewCheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.UsuarioDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.ICheckInService;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IHabitacionService;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IPersonaService;
import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
import com.gestionhotelera.cammons.habitaciones.model.Habitaciones;
import com.gestionhotelera.cammons.habitaciones.model.Personas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

    public void newCheckInDtoToCheckIn(NewCheckInDTO checkInDTO){
        CheckIn checkIn = new CheckIn();
        checkIn.setNumeroDias(checkInDTO.getNumeroDias());
        checkIn.setFechaIngreso(checkInDTO.getFechaIngreso());
        checkIn.setFechaSalida(checkInDTO.getFechaSalida());
        checkIn.setPersona(personaService.getPersonaByIdentificacion(checkInDTO.getIdentificadorPersona()));
        List<Habitaciones> habitaciones = checkInDTO.getHabitaciones().stream()
                .map(h -> habitacionService.getHabitacionByNumeroHabitacion(h.getNumeroHabitacion()))
                .collect(Collectors.toList());
        checkIn.setHabitacionCheckIn(habitaciones);
        checkInService.saveCheckIn(checkIn);
    }

}
