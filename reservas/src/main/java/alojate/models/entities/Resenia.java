package alojate.models.entities;

import lombok.Data;

@Data
public class Resenia {
    private Reserva reserva;
    private String resenia;
    private Puntaje puntaje;

}
