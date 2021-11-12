package com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.SinglePersonDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.ICheckInService;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.IPersonaService;
import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
import com.gestionhotelera.cammons.habitaciones.model.Personas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jhonc
 * @version 1.0
 * @since 11/11/2021
 */
@Component
@Transactional
public class PersonaMappedBy {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private ICheckInService checkInService;

    public ResponseEntity<?> personToSinglePersonDto(Long cedula){
        Map<String, Object> response = new HashMap<>();
        Personas persona = null;
        SinglePersonDTO singlePersonDTO = new SinglePersonDTO();
        CheckIn checkIn = null;
        try{
            persona = personaService.getPersonaByIdentificacion(cedula);
            if(persona == null){
                response.put("mensaje","El usuario con esta cedula ["+cedula
                        +"] no existe" );
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            singlePersonDTO.setCedula(persona.getIdentificacion());
            singlePersonDTO.setNombre(persona.getPriNombre() + " " + persona.getSegNombre());
            singlePersonDTO.setApellido(persona.getPriApellido() + " " + persona.getSegApellido());
            singlePersonDTO.setDireccion(persona.getDireccion());
            singlePersonDTO.setEmail(persona.getCorreo());
            singlePersonDTO.setTelefono(persona.getTelefono());

            checkIn = checkInService.getCheckByIdentificacion(singlePersonDTO.getCedula());
            if(checkIn != null){
                response.put("mensaje","Este usuario ya tiene asociado un Check-in");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        }catch(DataAccessException e){
            response.put("mensaje", "Error al a buscar el usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("singlePersonDTO",singlePersonDTO);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
