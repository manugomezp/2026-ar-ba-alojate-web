package alojate.usuarios.models.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    private String nombreCompleto;
    private String nacionalidad;
    //private List<MedioDePago> medioDePago;
    private List<String> preferencias;
    private List<String> mediosDeContacto;
    private LocalDate fechaNac;
    private String urlFoto;

}
