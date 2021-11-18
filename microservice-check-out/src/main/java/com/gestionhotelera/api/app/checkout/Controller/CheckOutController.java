package com.gestionhotelera.api.app.checkout.Controller;

import com.gestionhotelera.api.app.checkout.client.IClientHabitaciones;
import com.gestionhotelera.api.app.checkout.service.ICheckOutService;
import com.gestionhotelera.api.app.checkout.service.IVentaService;
import com.gestionhotelera.api.app.checkout.service.IpersonService;
import com.gestionhotelera.cammons.habitaciones.model.*;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckOutController {

    @Autowired
    private ICheckOutService service;

    @Autowired
    private IpersonService personService;

    @Autowired
    private IVentaService ventaService;

    @Autowired
    private IClientHabitaciones client;

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


    @PutMapping("/add-habitaciones/{id}")
    public ResponseEntity<CheckOut> addHabitaciones(@PathVariable Long id,@RequestBody List<Long> idHabitaciones){
        CheckOut checkOut = service.find(id);
        List<Habitaciones> habitaciones = idHabitaciones.stream().map(idHabitacion ->{
            return client.find(idHabitacion);
        }).collect(Collectors.toList());
        for (Habitaciones habitacion: habitaciones){
            habitacion.addCheckouts(checkOut);
            checkOut.addHabitacion(habitacion);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(checkOut));
    }

    @PutMapping("/add-pago/{id}")
    public ResponseEntity<Ventas> addPago(@PathVariable Integer id, @RequestBody Pagos pagos){
        Ventas ventas = ventaService.find(id);
        if(ventas == null) return ResponseEntity.badRequest().build();
        pagos.setVenta(ventas);
        ventas.setPago(pagos);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(ventas));
    }

    @GetMapping("/find/{identificacion}")
    public ResponseEntity<CheckOut> find(@PathVariable Long identificacion){
        return ResponseEntity.ok().body(service.findByIdentificacion(identificacion));
    }

    @GetMapping("/habitacion/{num}")
    public ResponseEntity<Habitaciones> findByNum(@PathVariable Long num){
        try {
           Habitaciones habitaciones = client.findByNumHabitacion(num);
            return ResponseEntity.ok().body(habitaciones);
        } catch (FeignException e){
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/findPerson/{cedula}")
    public ResponseEntity<Personas> finsByCedula(@PathVariable Long cedula){
        Personas personas = personService.findByCedula(cedula);
        if(personas == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(personas);
    }

     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
     }

     @GetMapping("/find-check/{id}")
    public ResponseEntity<?> findCheck(@PathVariable Long id){
        CheckOut checkOut = service.find(id);
        if(checkOut == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(checkOut);
     }

     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CheckOut checkOut){
       CheckOut checkUpdate = service.find(id);
       if(checkUpdate == null) return ResponseEntity.notFound().build();
       checkUpdate.setPersona(checkOut.getPersona());
       checkUpdate.setVentas(checkOut.getVentas());
       checkUpdate.setNumeroDias(checkOut.getNumeroDias());
       checkUpdate.setFechaEgreso(checkOut.getFechaEgreso());
       checkUpdate.setFechaIngreso(checkOut.getFechaIngreso());
       checkUpdate.setHabitacion(checkOut.getHabitacion());
       checkUpdate.setAdeudos(checkOut.getAdeudos());
       return ResponseEntity.status(HttpStatus.CREATED).body(service.save(checkUpdate));
     }

}
