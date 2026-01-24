package alojate.models.entities.publicacion;

import alojate.models.entities.geocoding.GeoCoding;
import alojate.models.entities.geocoding.LatLonDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String calle;
    @Column
    private String altura;
    @Column
    private String codigoPostal;
    @Column
    private Double latitud;
    @Column
    private Double longitud;
    @Column
    private String pais;
    @Column
    private String provincia;
    @Column
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
