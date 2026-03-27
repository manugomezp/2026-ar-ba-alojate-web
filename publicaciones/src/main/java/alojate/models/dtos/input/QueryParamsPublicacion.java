package alojate.models.dtos.input;

import lombok.Data;

import java.util.List;

@Data
public class QueryParamsPublicacion {
    private String pais;
    private String ciudad;
    private String checkIn;
    private String checkOut;
    private Integer adultos;
    private String categoria;
    private List<String> etiquetas;

    public QueryParamsPublicacion(String pais, String ciudad, String checkIn, String checkOut,
                                  Integer adultos, String categoria, List<String> etiquetas) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.adultos = adultos;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
    }





}
