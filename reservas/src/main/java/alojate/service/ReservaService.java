package alojate.service;

import alojate.models.dtos.ReservaDTO;
import alojate.events.ReservaEvent;
import alojate.models.entities.Destino;
import alojate.models.entities.Reserva;
import alojate.models.dtos.output.OutReservaDTO;
import alojate.models.repository.IReposReserva;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final IReposReserva reposReserva;
    private final ReservaEventPublisher reservaEventPublisher;

    public ReservaService(IReposReserva reposReserva, ReservaEventPublisher reservaEventPublisher) {
        this.reposReserva = reposReserva;
        this.reservaEventPublisher = reservaEventPublisher;
    }


    public void alta(ReservaDTO dto) {
        Destino destino  = new Destino("Buenos Aires, Argentina");
        Reserva reserva = new Reserva(dto.getViajero_id(), dto.getPublicacion_id(),
                dto.getNombre_publicacion(), dto.getNombre_viajero(),dto.getCheckIn(), dto.getCheckOut(),
                dto.getCostoAbonado(), dto.getCostoPorAbonar(), destino, dto.getEstado());

        reposReserva.save(reserva);
        reservaEventPublisher.publicarReservaCreada(new ReservaEvent(dto.getPublicacion_id(),
                dto.getCheckIn().toLocalDate(), dto.getCheckOut().toLocalDate()));
    }
    // SE PIDEN LAS PUBLICACIONES Y

    // OPCIÓN 1
        // PUBLICACIONES HACE UN GET A RESERVAS PARA CONOCER AQUELLAS PUBLICACIONES QUE
        // NO ESTÁN DISPONIBLES EN LA FECHA DADA. OSEA, RESERVAS DEVUELVE UNA LISTA DE STRING DE DICHAS PUBLICACIONES.
    // OPCIÓN 2
        // PUBLICACIONES LLEVA REGISTRO DE LAS FECHAS EN LAS QUE UNA PUBLICACIÓN ESTÁ RESERVADA PARA NO MOSTRARLA COMO OPCIÓN
    // PUEDE QUE LA OPCIÓN 2 SEA MEJOR PENSANDO EN RENDIMIENTO, PORQUE SE EXCUSA DE HACER UNA PETICIÓN A RESERVA Y QUE ESTA
    // BUSQUE AQUELLAS IDS PARA FECHA Y LUGAR COINCIDENTE.
    // CUANTAS PUBLICACIONES PUEDEN LLEGAR A SER SUBIDAS? 500? 1000? 2000? NO PARECE TANTO QUE PROCESAR.

    // QUÉ ES MAS ESCALABLE? SOLICITAR A RESERVAS SIN PERSISTIR EN PUBLICACIONES
    // O PERSISTIR EN PUBLICACIONES SIN CONSULTAR A RESERVAS?

//    public OutReservaDTO devolver(Long reserva_id){
//        Reserva reserva = reservas.stream()
//                .filter(r -> r.getId().equals(reserva_id))
//                .findFirst()
//                .orElse(null);
//
//        assert reserva != null;
//        return new OutReservaDTO(reserva.getNombre_publicacion(), reserva.getCheckIn(), reserva.getCheckOut(),
//                reserva.getDestino().getNombre(), reserva.getEstado().toString());
//    }

    public List<OutReservaDTO> devolverTodas(String viajero_id){
        List<Reserva> reservasDe = reposReserva.findAll().stream()
                .filter(r -> r.getViajero_id().equals(viajero_id))
                .toList();

        return reservasDe.stream().map(this::toDTO).toList();
    }

    public OutReservaDTO toDTO(Reserva reserva){
        System.out.println("ESTE ES EL NOMBRE DEL VIAJERO:" + reserva.getNombre_viajero());
        return new OutReservaDTO(reserva.getNombre_publicacion(), reserva.getCheckIn(), reserva.getCheckOut(),
                "Un Destino", reserva.getEstado().toString());
    }

}
