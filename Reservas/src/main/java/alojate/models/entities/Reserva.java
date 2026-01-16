package alojate.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Reserva {
    private String viajero_id;
    private String publicacion_id;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double costoAbonado;
    private Double costoPorAbonar;
    private Destino destino;
    private Estado estado;

    public Reserva(String viajero_id, String publicacion_id, LocalDateTime checkIn, LocalDateTime checkOut, Double costoAbonado, Double costoPorAbonar, Destino destino, Estado estado) {
        this.viajero_id = viajero_id;
        this.publicacion_id = publicacion_id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.costoAbonado = costoAbonado;
        this.costoPorAbonar = costoPorAbonar;
        this.destino = destino;
        this.estado = estado;
    }
}
