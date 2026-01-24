package alojate.models.repository;


import alojate.models.dtos.input.QueryParamsPublicacion;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.models.entities.publicacion.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IReposPublicacion extends JpaRepository<Publicacion, Long> {

//    @Query("""
//    SELECT h
//    FROM Hecho h
//    JOIN Fuente f ON h.fuente.id = f.id
//    WHERE (:categoria IS NULL OR UPPER(h.categoria.tipo) = :categoria)
//      AND (:fechaReporteDesde IS NULL OR h.fechaDeCarga >= :fechaReporteDesde)
//      AND (:fechaReporteHasta IS NULL OR h.fechaDeCarga <= :fechaReporteHasta)
//      AND (:fechaAcontecimientoDesde IS NULL OR h.fechaDelHecho >= :fechaAcontecimientoDesde)
//      AND (:fechaAcontecimientoHasta IS NULL OR h.fechaDelHecho <= :fechaAcontecimientoHasta)
//      AND (:provincia IS NULL OR UPPER(h.ubicacion.provincia) = :provincia)
//      AND (:fuente IS NULL OR UPPER(f.nombre) = :fuente)
//      AND h.eliminado = false
//""")
//    Page<Hecho> filtrarPorParametros(
//            String categoria,
//            String fechaReporteDesde,
//            String fechaReporteHasta,
//            LocalDateTime fechaAcontecimientoDesde,
//            LocalDateTime fechaAcontecimientoHasta,
//            String provincia,
//            String fuente,
//            Pageable pageable
//    );
    @Query("""
                SELECT p
                FROM Publicacion p
                WHERE (:pais IS NULL OR UPPER(p.ubicacion.pais) = :pais)
                  AND (:ciudad IS NULL OR p.ubicacion.ciudad >= :ciudad)
                  AND (:checkIn IS NULL OR p.validaDesde <= :checkIn)
                  AND (:checkOut IS NULL OR p.validaHasta >= :checkOut)
                  AND (:adultos IS NULL OR p.cantidad_adultos_maxima >= :adultos)
                  AND (:ambientes IS NULL OR p.cantidad_ambientes >= :ambientes)
                  AND p.estado = "ABIERTA"
            """)
    List<Publicacion> filtrar(String pais, String ciudad, LocalDateTime checkIn,
                              LocalDateTime checkOut, Integer adultos, Integer ambientes);

}
