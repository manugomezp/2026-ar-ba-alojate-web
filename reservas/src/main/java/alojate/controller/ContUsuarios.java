package alojate.controller;

import alojate.models.dtos.ReseniaDTO;
import alojate.models.dtos.ReservaDTO;
import alojate.models.dtos.output.OutReseniaDTO;
import alojate.models.dtos.output.OutReservaDTO;
import alojate.models.entities.Reserva;
import alojate.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:9000")
public class ContUsuarios{

    private final ReservaService reservaService;

    public ContUsuarios(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

//    @GetMapping("/api/publicaciones-reservadas")
//    public List<String> publicacionesReservadas(){
//        Reserva reserva = new Reserva("azkaban33344312");
//        Reserva reserva2 = new Reserva("alkamar333123");
//
//        return List.of(reserva.getPublicacionId(), reserva2.getPublicacionId());
//    }

    @PostMapping("/api/reservas")
    public void alta(@RequestBody ReservaDTO reservaDTO){
        reservaService.alta(reservaDTO);
    }

    @GetMapping("/api/reservas")
    public List<OutReservaDTO> devolverReservasDeViajero(@RequestParam("viajero_id") String id_viajero ){
        return reservaService.devolverReservasDeViajero(id_viajero);
    }

    @PostMapping("/api/reservas/resenias")
    public void alta(@RequestBody ReseniaDTO reseniaDTO){
        reservaService.alta(reseniaDTO);
    }

    @GetMapping("/api/reservas/resenias/")
    public List<OutReseniaDTO> devolverReseniasDePublicacion(@RequestParam("publicacion_id") String id_publicacion){
        return reservaService.devolverReseniasDePublicacion(id_publicacion);
    }


}
