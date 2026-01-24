package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nombre;

    public Categoria (String nombre) {
        this.nombre = nombre;
    }


}
