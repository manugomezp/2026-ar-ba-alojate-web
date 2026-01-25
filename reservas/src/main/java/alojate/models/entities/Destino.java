package alojate.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Destino {
    @Column
    private String nombre;
    @Column
    private String pais;

    @Column
    private String provincia;

    @Column
    private String ciudad;

    public Destino (String nombre){
        this.nombre = nombre;
    }


}
