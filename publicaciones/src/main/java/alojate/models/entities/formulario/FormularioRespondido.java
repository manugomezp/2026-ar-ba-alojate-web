package alojate.models.entities.formulario;

import alojate.models.entities.publicacion.Publicacion;
import lombok.Data;

import java.util.List;

@Data
public class FormularioRespondido {
    private Publicacion publicacion;
    private Formulario formulario;
    private List<Respuesta> respuestas;
}
