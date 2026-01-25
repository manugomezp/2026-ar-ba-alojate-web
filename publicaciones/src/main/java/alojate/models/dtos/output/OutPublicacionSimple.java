package alojate.models.dtos.output;

import lombok.Data;

@Data
public class OutPublicacionSimple {
    private String url;
    private String puntaje;
    private String precioPorNoche;
    private String descripción; // 30 caracteres máx
    private String categoria; // si es casa, departamento, etc.
    private String destino;

    public OutPublicacionSimple(String url, String puntaje, String precioPorNoche,
                                String descripción, String categoria, String destino ) {
        this.url = url;
        this.puntaje = puntaje;
        this.precioPorNoche = precioPorNoche;
        this.descripción = descripción;
        this.categoria = categoria;
        this.destino = destino;
    }
}