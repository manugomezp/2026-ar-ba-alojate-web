package alojate.models.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutReservaDTO {
    private String nombre_publicacion;
  //  private String nombre_viajero;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String destino;
    private String estado; // DEBE DEVOLVER SEGÚN EL ENUM EN EL MOMENTO.
}
