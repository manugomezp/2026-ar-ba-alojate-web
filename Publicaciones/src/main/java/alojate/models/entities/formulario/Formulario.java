package alojate.models.entities.formulario;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Formulario {
    private List<Pregunta> preguntas;
    private LocalDateTime fechaActualizacion;
    private String titulo;
}
