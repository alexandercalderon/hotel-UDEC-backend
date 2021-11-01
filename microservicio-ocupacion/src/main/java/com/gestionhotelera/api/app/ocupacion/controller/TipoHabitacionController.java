package com.gestionhotelera.api.app.ocupacion.controller;

import com.gestionhotelera.api.app.ocupacion.model.ImagenesHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.TipoHabitacion;
import com.gestionhotelera.api.app.ocupacion.model.habitaciones;
import com.gestionhotelera.api.app.ocupacion.service.ITipoHabitaciónService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipoHabitacionController {

    @Autowired
    private ITipoHabitaciónService service;

    @GetMapping("/list")
    public ResponseEntity<List<TipoHabitacion>> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("/show/{habitacion}/{imagen}")
    public ResponseEntity<?> find(@PathVariable Long habitacion, @PathVariable Long imagen){
        ImagenesHabitacion imagenen = service.find(habitacion, imagen);
        if(imagenen == null) return ResponseEntity.noContent().build();
        if(imagenen.getImagen() == null) return ResponseEntity.noContent().build();
        Resource img = new ByteArrayResource(imagenen.getImagen());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
    }

    @PutMapping("/update/{estado}/{idHabitacion}/{idTipoHabitacion}")
    public ResponseEntity<?> save(@PathVariable Character estado, @PathVariable Long idHabitacion, @PathVariable Long idTipoHabitacion){
        TipoHabitacion tipoHabitacion = service.find(idTipoHabitacion);
        if(tipoHabitacion == null) return ResponseEntity.notFound().build();
        habitaciones habitaciones = service.findHabitaciones(idHabitacion);
        if(habitaciones == null) return ResponseEntity.notFound().build();
        habitaciones.setEstado(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipoHabitacion));
    }

    @GetMapping("/filtrar/{estado}")
    public ResponseEntity<?> filtrar(@PathVariable Character estado){
        List<TipoHabitacion> filtrado = service.filtrado(estado);
        filtrado = filtrado.stream().distinct().collect(Collectors.toList());
        return ResponseEntity.ok().body(filtrado);
    }
}
