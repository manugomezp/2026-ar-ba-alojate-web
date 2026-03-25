package alojate.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "reservas")
@NoArgsConstructor
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "viajero_id")
    private String viajero_id;
    @Column(name = "publicacion_id")
    private String publicacionId;
    @Column(name = "nombre_publicacion")
    private String nombre_publicacion;
    @Column(name = "nombre_viajero")
    private String nombre_viajero;
    @Column(name = "check_in")
    private LocalDateTime checkIn;
    @Column(name = "check_out")
    private LocalDateTime checkOut;
    @Column(name = "costo_abonado")
    private Double costoAbonado;
    @Column(name = "costo_por_abonar")
    private Double costoPorAbonar;
    @Enumerated(EnumType.STRING)
    @Column
    private Estado estado;
    @Column
    private String destino;

    //
    public Reserva(String viajero_id, String publicacion_id, String nombre_pub, String nombre_viajero,
                   LocalDateTime checkIn, LocalDateTime checkOut, Double costoAbonado, Double costoPorAbonar, String destino, String estado) {
        this.viajero_id = viajero_id;
        this.publicacionId = publicacion_id;
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
        this.publicacionId
                = publicacion_id;
        }
}
