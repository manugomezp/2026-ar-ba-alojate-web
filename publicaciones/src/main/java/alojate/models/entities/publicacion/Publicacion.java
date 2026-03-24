package alojate.models.entities.publicacion;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
    @OneToOne
    private Ubicacion ubicacion;
    @Column
    private Integer cantidad_adultos_maxima;
    @Column
    private Integer cantidad_ambientes;
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
    private String horaDeEntrada;
    @Column
    private String horaDeSalida;
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
    private List<Etiqueta> etiquetas = new ArrayList<>();

    // CONSTRUCTOR PARA TESTEO
    public Publicacion(String titulo, LocalDateTime desde, LocalDateTime hasta,
                       Integer adultos, Integer ambientes, Divisa divisa, Double costoPorNoche,
                       Ubicacion ubicacion, Categoria categoria)
    {
        this.titulo = titulo;
        this.validaDesde = desde;
        this.validaHasta = hasta;
        this.cantidad_ambientes = ambientes;
        this.cantidad_adultos_maxima = adultos;
        this.estado = Estado.ABIERTA;
        this.costoPorNoche = costoPorNoche;
        this.divisa = divisa;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }

    public void agregarEtiqueta(Etiqueta etiqueta){
        etiquetas.add(etiqueta);
    }

//    public Publicacion( String titulo, LocalDateTime desde, LocalDateTime hasta,
//                       Integer adultos, Integer ambientes, Divisa divisa, Double costoPorNoche,
//                       Ubicacion ubicacion, Categoria categoria)
//    {
//        this.titulo = titulo;
//        this.validaDesde = desde;
//        this.validaHasta = hasta;
//        this.cantidad_ambientes = ambientes;
//        this.cantidad_adultos_maxima = adultos;
//        this.estado = Estado.ABIERTA;
//        this.costoPorNoche = costoPorNoche;
//        this.divisa = divisa;
//        this.ubicacion = ubicacion;
//        this.categoria = categoria;
//    }
//



}
