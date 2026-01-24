package alojate.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "resenia")
@NoArgsConstructor
@Data
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    private Reserva reserva;
    @Column
    private String resenia;
    @Enumerated(EnumType.STRING)
    private Puntaje puntaje;

}
