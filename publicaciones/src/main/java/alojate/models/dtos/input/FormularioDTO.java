package alojate.models.dtos.input;

import lombok.Data;

import java.util.List;

@Data
public class FormularioDTO {
    private  String nombre;
    private List<PreguntaDTO> preguntas;
}
