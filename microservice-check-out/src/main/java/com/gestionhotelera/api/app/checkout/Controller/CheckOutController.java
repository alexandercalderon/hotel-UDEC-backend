package com.gestionhotelera.api.app.checkout.Controller;

import com.gestionhotelera.api.app.checkout.service.ICheckOutService;
import com.gestionhotelera.api.app.checkout.service.IVentaService;
import com.gestionhotelera.api.app.checkout.service.IpersonService;
import com.gestionhotelera.cammons.habitaciones.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CheckOutController {

    @Autowired
    private ICheckOutService service;

    @Autowired
    private IpersonService personService;

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/list")
    public ResponseEntity<List<CheckOut>> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @PostMapping("/save/{idVenta}/{idPersona}")
    public ResponseEntity<CheckOut> save(@RequestBody CheckOut checkOut, @PathVariable Integer idVenta, @PathVariable Integer idPersona){
        Personas personas = personService.find(idPersona);
        if(personas == null) return ResponseEntity.badRequest().build();
        Ventas ventas = ventaService.find(idVenta);
        if(ventas == null) return ResponseEntity.badRequest().build();
        checkOut.setVentas(ventas);
        checkOut.setPersona(personas);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(checkOut));
    }

    @PutMapping("/add-adeudos/{id}")
    public ResponseEntity<CheckOut> addAdeudos(@RequestBody List<Adeudo> adeudos, @PathVariable Long id){
        CheckOut checkOut = service.find(id);
        if(checkOut == null) return ResponseEntity.badRequest().build();
        for (Adeudo adeudo: adeudos){
            adeudo.setCheckOut(checkOut);
            checkOut.addAdeudos(adeudo);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(checkOut));
    }
    @PostMapping("/addVentas")
    public ResponseEntity<Ventas> addVentas(@RequestBody Ventas ventas){
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(ventas));
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Personas> addPerson(@RequestBody Personas persona){
       return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(persona));
    }

    @PutMapping("/add-habitaciones/{id}/{idHabitacion}")
    public ResponseEntity<CheckOut> addHabitaciones(@RequestBody List<Habitaciones> habitaciones, @PathVariable Long id, @PathVariable Integer idHabitacion){
        CheckOut checkOut = service.find(id);
        if(checkOut == null) return ResponseEntity.badRequest().build();
        Habitaciones habitacion =
        for(Habitaciones habitacion: habitaciones){
            habitacion.addCheckouts(checkOut);
            checkOut.addHabitacion(habitacion);
        }
    }

}
