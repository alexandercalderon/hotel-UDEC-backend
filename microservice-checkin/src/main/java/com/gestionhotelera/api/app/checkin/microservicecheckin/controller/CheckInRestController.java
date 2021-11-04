package com.gestionhotelera.api.app.checkin.microservicecheckin.controller;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.PersonaDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.service.ICheckInService;
import com.gestionhotelera.cammons.habitaciones.model.CheckIn;
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

    @GetMapping("/all")
    public ResponseEntity<?> allCheckIn(){
        Map<String, Object> response = new HashMap<>();
        List<CheckIn> lista = checkInService.getAllChechIn();
        if(lista.isEmpty()){
            response.put("mensaje","No hay Check-In's");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCheckInById(@PathVariable Long id){
        CheckIn checkIn = null;
        Map<String, Object> response = new HashMap<>();
        try{
            checkIn = checkInService.getCheckInOf(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(checkIn == null){
            response.put("mensaje","El Check-in con id: " + id + ", no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(checkIn, HttpStatus.OK);
    }

    @PostMapping("/get/identificacion")
    public ResponseEntity<?> viewCheckInByCedula(@RequestBody PersonaDTO personaDTO){
        CheckIn checkIn = null;
        Map<String, Object> response = new HashMap<>();
        try{
            //todo
            checkIn = checkInService.getCheckByIdentificacion(personaDTO.getIdentificacion());
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(checkIn == null){
            response.put("mensaje","El Check-in asociada a esta cedula " + personaDTO.getIdentificacion()
                    + ", no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(checkIn, HttpStatus.OK);
    }


    //Crear un check-in y se le asigna el usario por @PathVariable
    @PostMapping(value = "/save")
    public ResponseEntity<?> createCheckIn(@Valid @RequestBody CheckIn checkIn, BindingResult result) {
        //todo
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo: [" + err.getField() + "]: " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            checkInService.saveCheckIn(checkIn);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al CheckIn");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Check-In creado con exito");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
