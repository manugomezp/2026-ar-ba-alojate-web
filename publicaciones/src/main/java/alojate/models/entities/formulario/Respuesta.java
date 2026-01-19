package alojate.models.entities.formulario;

import lombok.Data;

import java.util.List;

@Data
public class Respuesta {
    private Pregunta pregunta;
    private String respuesta;
    private List<Opcion> opciones_elegidas;

}
