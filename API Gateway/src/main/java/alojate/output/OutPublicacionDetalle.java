package alojate.output;

import lombok.Data;

import java.util.List;

@Data
public class OutPublicacionDetalle {
    private String titulo;
    private String categoria;
    private List<String> etiquetas; // WIFI, COCINA, TV, COCHERA, ETC.
   // private List<MultimediaDTO> multimedia;
    private String capacidad;
    private String descripcion;
    private Double costoPorNoche;
    private String checkIn;
    private String checkOut;
   // private Boolean cancelacionGratuita; etiqueta!?


}
