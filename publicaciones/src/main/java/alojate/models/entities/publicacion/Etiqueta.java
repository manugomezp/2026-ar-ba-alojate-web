package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "etiqueta")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //VAN A SER PRECARGADAS, AUNQUE EL ADMIN TAMBIÉN DEBIERA PODER AGREGAR UNA.
    // SI ES QUE HAGO PANTALLA DE ADMIN, JAJA.
    @Column
    private String nombre;
    @Column
    private String logo;

    public Etiqueta(String nombre) {
        this.nombre = nombre;
    }
}
