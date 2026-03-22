package alojate.models.dtos.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validaDesde;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validaHasta;
    private List<String> etiquetas;
}