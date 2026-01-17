package alojate.input;

import java.time.LocalDateTime;
import java.util.List;

public class InPublicacion {
    private String titulo;
    private String anfitrion_id;
    private String categoria;
    private List<MultimediaDTO> multimedia;
    private String ubicacion;
    private String capacidad;
    private String descripcion;
    private Double costoPorNoche;
    private String divisa;
    //private List<FormularioRespondido> formularioDeAmenities;
    private String formaDePago;
    private String checkIn;
    private String checkOut;
    private Boolean cancelacionGratuita;
    private LocalDateTime validaDesde;
    private LocalDateTime validaHasta;
}
