package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "publicacion")
public class Publicacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private LocalDateTime fecha;
    @Column
    private String anfitrion_id;
    @ManyToOne
    private Categoria categoria;
    @OneToMany
    private List<Multimedia> multimedia;
    @OneToOne
    private Ubicacion ubicacion;
    @Column
    private String capacidad;
    @Column
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column
    private Double costoPorNoche;
    @ManyToOne
    private Divisa divisa;
    @ManyToOne
    private FormaDePago formaDePago;
    @Column
    private LocalDateTime checkIn;
    @Column
    private LocalDateTime checkOut;
    @Column
    private Boolean cancelacionGratuita;
    @Column
    private LocalDateTime validaDesde;
    @Column
    private LocalDateTime validaHasta;
    @Column
    private String puntaje;
    @ManyToMany
    @JoinTable(
            name = "publicacion_etiqueta",
            joinColumns = @JoinColumn(name = "publicacion_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> etiquetas;

}
