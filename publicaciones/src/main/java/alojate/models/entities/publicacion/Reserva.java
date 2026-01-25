package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Publicacion publicacion;
    @Column
    private LocalDateTime checkIn;
    @Column
    private LocalDateTime checkOut;

}
