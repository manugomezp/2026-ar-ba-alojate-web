package alojate.service;

import alojate.models.dtos.ReservaDTO;
import alojate.models.entities.Reserva;
import alojate.models.dtos.output.OutReservaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();


    public void alta(ReservaDTO dto) {
        Reserva reserva = new Reserva();

        reserva.setViajero_id(dto.getViajero_id());
        reserva.setPublicacion_id(dto.getPublicacion_id());
        reserva.setNombre_publicacion(dto.getNombre_publicacion());
        reserva.setNombre_viajero(dto.getNombre_viajero());
        reserva.setCheckIn(dto.getCheckIn());
        reserva.setCheckOut(dto.getCheckOut());
        reserva.setCostoAbonado(dto.getCostoAbonado());
        reserva.setCostoPorAbonar(dto.getCostoPorAbonar());
       // reserva.setDestino(dto.getDestino().);

        reservas.add(reserva);
    }

    public OutReservaDTO devolver(Long reserva_id){
        Reserva reserva = reservas.stream()
                .filter(r -> r.getId().equals(reserva_id))
                .findFirst()
                .orElse(null);

        assert reserva != null;
        return new OutReservaDTO(reserva.getNombre_publicacion(), reserva.getCheckIn(), reserva.getCheckOut(),
                reserva.getDestino().getNombre(), reserva.getEstado().toString());
    }

    public List<OutReservaDTO> devolverTodas(String viajero_id){
        List<Reserva> reservasDe = reservas.stream()
                .filter(r -> r.getViajero_id().equals(viajero_id))
                .toList();

        return reservasDe.stream().map(this::toDTO).toList();
    }

    public OutReservaDTO toDTO(Reserva reserva){
        return new OutReservaDTO(reserva.getNombre_publicacion(), reserva.getCheckIn(), reserva.getCheckOut(),
                reserva.getDestino().getNombre(), reserva.getEstado().toString());
    }

}
