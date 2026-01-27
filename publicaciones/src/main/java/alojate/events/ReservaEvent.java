package alojate.events;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ReservaEvent {
    private String publicacion_id;
    private LocalDate desde;
    private LocalDate hasta;

    public ReservaEvent(){

    }
}
