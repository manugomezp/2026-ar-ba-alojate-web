package alojate.models.dtos.input;

import lombok.Data;

@Data
public class PreguntaDTO {
    private Long id;
    private String pregunta;
    private String tipoDePregunta;
}
