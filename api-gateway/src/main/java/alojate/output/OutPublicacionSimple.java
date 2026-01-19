package alojate.output;

import lombok.Data;

@Data
public class OutPublicacionSimple {
    private String url;
    private String puntaje;
    private String precioPorNoche;
    private String descripción; // 30 caracteres máx
    private String categoria; // si es casa, departamento, etc.
}
