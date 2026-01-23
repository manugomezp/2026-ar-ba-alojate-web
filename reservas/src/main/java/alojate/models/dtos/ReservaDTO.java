package alojate.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private String viajero_id;
    private String publicacion_id;
    private String nombre_publicacion;
    private String nombre_viajero;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double costoAbonado;
    private Double costoPorAbonar;
    private String destino;
    private String estado;
}
