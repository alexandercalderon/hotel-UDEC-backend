package com.gestionhotelera.api.app.checkout.Controller;

import com.gestionhotelera.api.app.checkout.service.ICheckOutService;
import com.gestionhotelera.cammons.habitaciones.model.CheckOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckOutController {

    @Autowired
    private ICheckOutService service;

    @GetMapping("/list")
    public ResponseEntity<List<CheckOut>> list(){
        return ResponseEntity.ok().body(service.list());
    }

}
