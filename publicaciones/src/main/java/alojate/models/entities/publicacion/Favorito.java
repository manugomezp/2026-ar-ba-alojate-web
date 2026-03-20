package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Favorito {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String userId;
    @ManyToOne
    private Publicacion publicacion;
    @Column
    private String nombre;
    @Column
    private String puntaje;
    @Column
    private Boolean favorito;

    public Favorito(String user_id, Publicacion publicacion) {
        this.userId = user_id;
        this.publicacion = publicacion;
        this.favorito = true;
    }
}