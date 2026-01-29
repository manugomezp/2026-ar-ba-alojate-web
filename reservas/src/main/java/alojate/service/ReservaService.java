package alojate.service;

import alojate.models.dtos.ReseniaDTO;
import alojate.models.dtos.ReservaDTO;
import alojate.events.ReservaEvent;
import alojate.models.dtos.output.OutReseniaDTO;
import alojate.models.entities.Destino;
import alojate.models.entities.Puntaje;
import alojate.models.entities.Resenia;
import alojate.models.entities.Reserva;
import alojate.models.dtos.output.OutReservaDTO;
import alojate.models.repository.IReposResenia;
import alojate.models.repository.IReposReserva;
import org.hibernate.dialect.function.SybaseTruncFunction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservaService {

    private final IReposReserva reposReserva;
    private final ReservaEventPublisher reservaEventPublisher;
    private final IReposResenia iReposResenia;

    public ReservaService(IReposReserva reposReserva, ReservaEventPublisher reservaEventPublisher, IReposResenia iReposResenia) {
        this.reposReserva = reposReserva;
        this.reservaEventPublisher = reservaEventPublisher;
        this.iReposResenia = iReposResenia;
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

    public List<OutReservaDTO> devolverReservasDeViajero(String viajero_id){
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

    public void alta(ReseniaDTO dto){
        try{
            iReposResenia.save(new Resenia(
                    reposReserva.findById(dto.getReserva_id()).get(),
                    dto.getResenia(),
                    Puntaje.valueOf(dto.getPuntaje())));
        }
        catch (NoSuchElementException n){
            System.out.println("La resenia no fue cargada pues no pudo ser asociada a ninguna reserva.");
        };

    }

    public List<OutReseniaDTO> devolverReseniasDePublicacion(String public_id){
        List<Reserva> reservas = reposReserva.findByPublicacionId(public_id);

        List<Resenia> resenias = iReposResenia.findAllByReservas(reservas);

        return resenias.stream().map(this::reseniaToDTO).toList();
    }

    public OutReseniaDTO reseniaToDTO(Resenia resenia){
        return new OutReseniaDTO(resenia.getResenia(), resenia.getPuntaje().toString(), resenia.getReserva().getNombre_viajero());
    }

}
