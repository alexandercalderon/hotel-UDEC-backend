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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class TipoHabitacionController {

    @Autowired
    private ITipoHabitaciónService service;

    @GetMapping("/list")
    public ResponseEntity<List<TipoHabitacion>> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @PostMapping("/agregar_imagen/{id}")
    public ResponseEntity<?> save(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException{
        habitaciones habitaciones = service.find(id);
        ImagenesHabitacion imagen = new ImagenesHabitacion();
        imagen.setImagen(file.getBytes());
        imagen.setHabitaciones(habitaciones);
        habitaciones.addImagen(imagen);
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(habitaciones));

    }

    @GetMapping("/show/{habitacion}/{imagen}")
    public ResponseEntity<?> find(@PathVariable Long habitacion, @PathVariable Long imagen){
        ImagenesHabitacion imagenen = service.find(habitacion, imagen);
        if(imagenen.getImagen() == null) return ResponseEntity.noContent().build();
        Resource img = new ByteArrayResource(imagenen.getImagen());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
    }

}
