package alojate.controller;

import alojate.models.entities.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:9000")
public class ContUsuarios{


    @GetMapping("/api/reservas")
    public String reservas() {
        return "Hola desde reservas!";
    }

    @GetMapping("/api/publicaciones-reservadas")
    public List<String> publicacionesReservadas(){
        Reserva reserva = new Reserva("azkaban33344312");
        Reserva reserva2 = new Reserva("alkamar333123");

        return List.of(reserva.getPublicacion_id(), reserva2.getPublicacion_id());
    }


}
