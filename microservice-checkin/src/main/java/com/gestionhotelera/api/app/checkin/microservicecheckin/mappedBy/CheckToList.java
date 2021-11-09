package com.gestionhotelera.api.app.checkin.microservicecheckin.mappedBy;

import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.CheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.ListCheckInDTO;
import com.gestionhotelera.api.app.checkin.microservicecheckin.dto.NewCheckInDTO;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jhonc
 * @version 1.0
 * @since 8/11/2021
 */
public class CheckToList {

    @Autowired
    private ICheckInService checkInService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IHabitacionService habitacionService;

    public static List<ListCheckInDTO> checkInToListCheckInDto(List<CheckIn> checkIns) {
        return checkIns.stream()
                .map(c -> new ListCheckInDTO(
                        c.getId()
                        , c.getNumeroDias()
                        , String.valueOf(c.getFechaIngreso())
                        , String.valueOf(c.getFechaSalida()))
                    )
                .collect(Collectors.toList());
    }


}
