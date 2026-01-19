package alojate.models.entities.publicacion;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class Publicacion {
    private String titulo;
    private LocalDateTime fecha;
    private String anfitrion_id;
    private Categoria categoria;
    private List<Multimedia> multimedia;
    private Ubicacion ubicacion;
    private String capacidad;
    private String descripcion;
    private Estado estado;
    private Double costoPorNoche;
    private Divisa divisa;
    private FormaDePago formaDePago;
    private String checkIn;
    private String checkOut;
    private Boolean cancelacionGratuita;
    private LocalDateTime validaDesde;
    private LocalDateTime validaHasta;
    private String puntaje;
    private List<Etiqueta> etiquetas;

}
