package alojate.models.dtos.input;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioDTO {
    private String nombreCompleto;
    private String nacionalidad;
    //private List<MedioDePago> medioDePago;
    private List<String> preferencias;
    private List<String> mediosDeContacto;
    private LocalDate fechaNac;
    private String urlFoto;

}
