package alojate.models.dtos.input;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PublicacionDTO {
    private String titulo;
    private String anfitrion_id;
    private String categoria;
    private String calle;
    private String altura;
    private String pais;
    private String codigoPostal;
    private String provincia;
    private String ciudad;
    private Integer capacidad;
    private String descripcion;
    private Double costoPorNoche;
    private String divisa;
    private String formaDePago;
    private String horaDeEntrada;
    private String horaDeSalida;
    private Boolean cancelacionGratuita;
    private LocalDateTime validaDesde;
    private LocalDateTime validaHasta;


}
