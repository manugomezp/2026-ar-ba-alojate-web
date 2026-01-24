package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forma_de_pago")
public class FormaDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MomentoDePago momentoDePago;
    @Column
    private Integer pcjeSenia;
    @Enumerated(EnumType.STRING)
    private List<MedioDePago> mediosDePago;

}
