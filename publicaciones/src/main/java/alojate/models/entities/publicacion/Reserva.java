package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="reserva")
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Publicacion publicacion;
    @Column
    private LocalDate checkIn;
    @Column
    private LocalDate checkOut;

    public Reserva(Publicacion publicacion, LocalDate checkIn, LocalDate checkOut) {
        this.publicacion = publicacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
