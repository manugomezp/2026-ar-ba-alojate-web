package alojate.output;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OutReservaDetalle {
    private String nombre_viajero;
    private String nombre_publicacion;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double costoAbonado;
    private Double costoPorAbonar;
    private String destino;

}
