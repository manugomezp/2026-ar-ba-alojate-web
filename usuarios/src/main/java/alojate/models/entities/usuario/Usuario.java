package alojate.usuarios.models.entities.usuario;

import alojate.models.entities.usuario.MedioDeContacto;
import alojate.models.entities.usuario.Nacionalidad;
import alojate.models.entities.usuario.Preferencia;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
public class Usuario {
    private String nombreCompleto;
    private Nacionalidad nacionalidad;
    //private List<MedioDePago> medioDePago;
    private List<Preferencia> preferencias;
    private List<MedioDeContacto> mediosDeContacto;
    // DEBEN SER PRECARGADAS Y PUEDEN INCLUIR EJEMPLOS COMO
    // "CERCA_DEL_CENTRO", "CERCA_DEL_MAR", "CASA", "DEPARTAMENTO"
    // MMM, REVISAR SU UTILIDAD MÁS ADELANTE.
    private LocalDate fechaNac;
    private String urlFoto;

    public Integer edad(){
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

}
