package alojate.input;

import lombok.Data;

import java.time.LocalDateTime;



@Data
public class InReserva {
    private String viajero_id;
    private String publicacion_id;
    private String nombre_publicacion;
    private String nombre_viajero;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double costoAbonado;
    private Double costoPorAbonar;
    private String destino;
}
