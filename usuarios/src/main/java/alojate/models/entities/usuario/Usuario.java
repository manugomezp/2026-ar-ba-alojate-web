package alojate.models.entities.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Nacionalidad nacionalidad;

  //  @OneToMany
    private List<Preferencia> preferencias;

    @OneToMany
    private List<MedioDeContacto> mediosDeContacto;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNac;

    @Column(name = "url_foto")
    private String urlFoto;


    public Integer edad(){
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

}
