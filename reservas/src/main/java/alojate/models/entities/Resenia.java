package alojate.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "resenia")
@NoArgsConstructor
@Data
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reserva reserva;
    @Column
    private String resenia;
    @Enumerated(EnumType.STRING)
    private Puntaje puntaje;

    public Resenia(Reserva reserva, String resenia, Puntaje puntaje) {
        this.reserva = reserva;
        this.resenia = resenia;
        this.puntaje = puntaje;
    }
}
