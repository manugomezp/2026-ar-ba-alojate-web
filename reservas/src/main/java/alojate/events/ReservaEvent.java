package alojate.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ReservaEvent {
    String publicacion_id;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDate desde;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDate hasta;

    public ReservaEvent(String publicacion_id, LocalDate desde, LocalDate hasta) {
        this.publicacion_id = publicacion_id;
        this.desde = desde;
        this.hasta = hasta;
    }

    public ReservaEvent(){

    }
}
