package alojate.models.entities.formulario;

import lombok.Data;

import java.util.List;

@Data
public class Pregunta {
    private String pregunta;
    private TipoDePregunta tipoDePregunta;
    private List<Opcion> opciones;
}
