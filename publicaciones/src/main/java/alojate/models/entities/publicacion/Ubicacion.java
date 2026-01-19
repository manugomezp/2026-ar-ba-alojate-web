package alojate.models.entities.publicacion;

import alojate.models.entities.geocoding.GeoCoding;
import alojate.models.entities.geocoding.LatLonDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Ubicacion {
    private String calle;
    private String altura;
    private String codigoPostal;
    private Double latitud;
    private Double longitud;
    private String pais;
    private String provincia;
    private String ciudad;

    public Ubicacion(String calle, String altura, String codigoPostal, String pais,  String ciudad) {
        this.calle = calle;
        this.altura = altura;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public void asignarCoordenadas(Double latitud, Double longitud){
        this.latitud = latitud;
        this.longitud = longitud;

   }

    public void obtenerCoordenadas(GeoCoding geoCoding) {
        LatLonDTO dto = geoCoding.obtener(this).block();
        if (Objects.requireNonNull(dto).getLat() != null && Objects.requireNonNull(dto).getLon() != null) {
            setLatitud(dto.getLat());
            setLongitud(dto.getLon());
        }
    }

}
