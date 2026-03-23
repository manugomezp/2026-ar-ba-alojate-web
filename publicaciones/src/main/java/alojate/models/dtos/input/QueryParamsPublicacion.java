package alojate.models.dtos.input;

import lombok.Data;

@Data
public class QueryParamsPublicacion {
    private String pais;
    private String ciudad;
    private String checkIn;
    private String checkOut;
    private Integer adultos;

    public QueryParamsPublicacion(String pais,
                           String ciudad,
                           String checkIn,
                           String checkOut,
                           Integer adultos) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.adultos = adultos;
    }

}
