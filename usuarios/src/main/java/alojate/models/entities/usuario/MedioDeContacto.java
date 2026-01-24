package alojate.models.entities.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class MedioDeContacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String valor;
    @Enumerated(EnumType.STRING)
    private Medio medio;
}
