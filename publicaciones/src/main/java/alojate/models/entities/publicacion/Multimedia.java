package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Multimedia")
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoArchivo tipo;
    @Column
    private String url;

    public Multimedia(TipoArchivo tipo, String url) {
        this.tipo = tipo;
        this.url = url;
    }
}
