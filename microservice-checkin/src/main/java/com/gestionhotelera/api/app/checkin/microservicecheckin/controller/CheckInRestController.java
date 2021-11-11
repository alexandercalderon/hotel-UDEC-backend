package com.gestionhotelera.api.app.checkin.microservicecheckin.controller;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.CheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.NewCheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.PersonaDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy.CheckMappedBy;
import com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy.CheckToList;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jhonc
 * @version 1.0
 * @since 28/10/2021
 */
@RestController
@RequestMapping("/check-in")
@CrossOrigin(origins = "http://localhost:4200")
public class CheckInRestController {

    @Autowired
    private ICheckInService checkInService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IHabitacionService habitacionService;

    @Autowired
    private CheckMappedBy checkMappedBy;

    @GetMapping("/all")
    public ResponseEntity<?> allCheckIn() {
        Map<String, Object> response = new HashMap<>();
        List<CheckIn> lista = checkInService.getAllChechIn();
        if (lista.isEmpty()) {
            response.put("mensaje", "No hay Check-In's");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(CheckToList.checkInToListCheckInDto(lista), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCheckInById(@PathVariable Long id) {
        CheckIn checkIn = null;
        Map<String, Object> response = new HashMap<>();
        CheckInDTO checkInDTO = null;
        try {
            checkIn = checkInService.getCheckInOf(id);
            if (checkIn == null) {
                response.put("mensaje", "El Check-in con id [" + id + "] no existe");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }else{
                checkInDTO = checkMappedBy.checkInToCheckInDTO(checkIn);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("checkIn", checkInDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/get/identificacion")
    public ResponseEntity<?> viewCheckInByCedula(@RequestBody PersonaDTO personaDTO) {
        CheckIn checkIn = null;
        CheckInDTO checkInDTO = null;
        Map<String, Object> response = new HashMap<>();
        Personas p = null;
        try {
            p = personaService.getPersonaByIdentificacion(personaDTO.getIdentificacion());
            if(p == null){
                response.put("mensaje","El usuario no existe");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            checkIn = checkInService.getCheckByIdentificacion(personaDTO.getIdentificacion());
            if (checkIn == null) {
                response.put("mensaje", "El Check-in asociada a esta cedula " + personaDTO.getIdentificacion()
                        + ", no existe");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }else{
                checkInDTO = checkMappedBy.checkInToCheckInDTO(checkIn);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("checkInDTO", checkInDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Crear un check-in y se le asigna el usario por @PathVariable
    @PostMapping(value = "/save")
    public ResponseEntity<?> createCheckIn(@Valid @RequestBody NewCheckInDTO dto,
                                           BindingResult result) {
        CheckIn checkIn = new CheckIn();
        List<Habitaciones> habitaciones = null;
        Personas persona = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo: [" + err.getField() + "]: " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            persona = personaService.getPersonaByIdentificacion(dto.getIdentificadorPersona());
            if(persona == null){
                response.put("error","La persona no existe");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            habitaciones = dto.getHabitaciones().stream()
                    .map(h -> {
                        Habitaciones hab = habitacionService.getHabitacionByNumeroHabitacion(h.getNumeroHabitacion());
                        if(hab == null){
                            response.put("mensaje","La habitacion: " + h.getNumeroHabitacion() + ", no existe");
                        }
                        return hab;
                    })

                    .collect(Collectors.toList());
            for(Habitaciones h : habitaciones){
                if(h == null){
                    response.put("error","No existe la habitacion");
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                }
            }
            checkIn.setNumeroDias(dto.getNumeroDias());
            checkIn.setFechaIngreso(dto.getFechaIngreso());
            checkIn.setFechaSalida(dto.getFechaSalida());
            checkIn.setPersona(persona);
            checkIn.setHabitacionCheckIn(habitaciones);
            checkInService.saveCheckIn(checkIn);
            response.put("mensaje", "Check-In creado con exito");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el CheckIn");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateCheckIn(@Valid @RequestBody NewCheckInDTO dto,
                                           BindingResult result, @PathVariable Long id) {
        CheckIn checkIn = new CheckIn();
        List<Habitaciones> habitaciones = null;
        Personas persona = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo: [" + err.getField() + "]: " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            checkIn = checkInService.getCheckInOf(id);
            if(checkIn == null){
                response.put("error","El Check-in para ser actualizado no existe");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            persona = personaService.getPersonaByIdentificacion(dto.getIdentificadorPersona());
            if(persona == null){
                response.put("error","La persona no existe");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            habitaciones = dto.getHabitaciones().stream()
                    .map(h -> {
                        Habitaciones hab = habitacionService.getHabitacionByNumeroHabitacion(h.getNumeroHabitacion());
                        if(hab == null){
                            response.put("mensaje","La habitacion: " + h.getNumeroHabitacion() + ", no existe");
                        }
                        return hab;
                    })

                    .collect(Collectors.toList());
            for(Habitaciones h : habitaciones){
                if(h == null){
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                }
            }
            checkIn.setNumeroDias(dto.getNumeroDias());
            checkIn.setFechaIngreso(dto.getFechaIngreso());
            checkIn.setFechaSalida(dto.getFechaSalida());
            checkIn.setPersona(persona);
            checkIn.setHabitacionCheckIn(habitaciones);
            checkInService.saveCheckIn(checkIn);
            response.put("mensaje", "Check-In actualizado con exito");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el CheckIn");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCheckIn(@PathVariable Long id){
        CheckIn checkIn = new CheckIn();
        Map<String, Object> response = new HashMap<>();
        checkIn = checkInService.getCheckInOf(id);
        if(checkIn == null){
            response.put("error","El Check-in a eliminar no existe");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try{
            checkInService.deleteCheckInById(checkIn.getId());
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el CheckIn");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","Check-in Eliminado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
