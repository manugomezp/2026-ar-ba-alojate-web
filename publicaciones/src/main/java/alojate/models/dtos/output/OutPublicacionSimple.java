package alojate.models.dtos.output;

import lombok.Data;

import java.util.List;

@Data
public class OutPublicacionSimple {
    private Long id;
    private String puntaje;
    private String precioPorNoche;
    private String descripcion; // 30 caracteres máx
    private String categoria; // si es casa, departamento, etc.
    private String destino;
    private List<Long> multimedia;

    public OutPublicacionSimple(Long id, List<Long> multimedia, String puntaje, String precioPorNoche,
                                String descripcion, String categoria, String destino ) {
        this.puntaje = puntaje;
        this.precioPorNoche = precioPorNoche;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.destino = destino;
        this.multimedia = multimedia;
        this.id = id;
    }
}