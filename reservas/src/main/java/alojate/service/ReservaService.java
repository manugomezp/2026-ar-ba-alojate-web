package alojate.service;

import alojate.models.dtos.ReservaDTO;
import alojate.models.entities.Destino;
import alojate.models.entities.Reserva;
import alojate.models.dtos.output.OutReservaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();


    public void alta(ReservaDTO dto) {
        Destino destino  = new Destino("Buenos Aires, Argentina");
        Reserva reserva = new Reserva(dto.getViajero_id(), dto.getPublicacion_id(),
                dto.getNombre_publicacion(), dto.getNombre_viajero(),dto.getCheckIn(), dto.getCheckOut(),
                dto.getCostoAbonado(), dto.getCostoPorAbonar(), destino, dto.getEstado());
        reservas.add(reserva);
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

    public List<OutReservaDTO> devolverTodas(String viajero_id){
        List<Reserva> reservasDe = reservas.stream()
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
