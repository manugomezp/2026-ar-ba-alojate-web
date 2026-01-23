package alojate.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Reserva {
    private Long id;
    private String viajero_id;
    private String publicacion_id;
    private String nombre_publicacion;
    private String nombre_viajero;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double costoAbonado;
    private Double costoPorAbonar;
    private Destino destino;
    private Estado estado;

    //
    public Reserva(String viajero_id, String publicacion_id, String nombre_pub, String nombre_viajero,
                   LocalDateTime checkIn, LocalDateTime checkOut, Double costoAbonado, Double costoPorAbonar, Destino destino, String estado) {
        this.viajero_id = viajero_id;
        this.publicacion_id = publicacion_id;
        this.nombre_publicacion = nombre_pub;
        this.nombre_viajero = nombre_viajero;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.costoAbonado = costoAbonado;
        this.costoPorAbonar = costoPorAbonar;
        this.destino = destino;
        if(estado.equals("FAVORITO"))
            this.estado = Estado.FAVORITO;
        else if(estado.equals("REALIZADA"))
            this.estado = Estado.REALIZADA;
    }


    public Reserva(String publicacion_id)
        {
        this.publicacion_id = publicacion_id;
        }
}
