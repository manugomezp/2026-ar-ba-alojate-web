package alojate.models.entities.publicacion;

import lombok.Data;

@Data
public class Etiqueta {
    //VAN A SER PRECARGADAS, AUNQUE EL ADMIN TAMBIÉN DEBIERA PODER AGREGAR UNA.
    // SI ES QUE HAGO PANTALLA DE ADMIN, JAJA.
    private String nombre;
    private String logo;

}
