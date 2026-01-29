package alojate.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReseniaDTO {
    private String puntaje;
    private String resenia;
    private Long reserva_id;
}
