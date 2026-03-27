package alojate.models.repository;


import alojate.models.dtos.input.QueryParamsPublicacion;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.models.entities.publicacion.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IReposPublicacion extends JpaRepository<Publicacion, Long> {

//    @Query("""
//                SELECT p
//                FROM Publicacion p
//                WHERE (:pais IS NULL OR p.ubicacion.pais = :pais)
//                  AND (:ciudad IS NULL OR p.ubicacion.ciudad = :ciudad)
//                  AND (:checkIn IS NULL OR p.validaDesde <= :checkIn)
//                  AND (:checkOut IS NULL OR p.validaHasta >= :checkOut)
//                  AND (:adultos IS NULL OR p.cantidad_adultos_maxima >= :adultos)
//                  AND p.estado = "ABIERTA"
//            """)
//    List<Publicacion> filtrar(String pais, String ciudad, LocalDateTime checkIn,
//                              LocalDateTime checkOut, Integer adultos);

    @Query("""
    SELECT p
    FROM Publicacion p
    WHERE (:pais IS NULL OR p.ubicacion.pais = :pais)
      AND (:ciudad IS NULL OR p.ubicacion.ciudad = :ciudad)
      AND (:checkIn IS NULL OR p.validaDesde <= :checkIn)
      AND (:checkOut IS NULL OR p.validaHasta >= :checkOut)
      AND (:adultos IS NULL OR p.cantidad_adultos_maxima >= :adultos)
      AND (:categoria IS NULL OR p.categoria.nombre = :categoria)
      AND p.estado = 'ABIERTA'
      AND (
          :etiquetas IS NULL OR NOT EXISTS (
              SELECT et
              FROM Etiqueta et
              WHERE et.nombre IN :etiquetas
                AND et NOT MEMBER OF p.etiquetas
          )
      )
""")
    List<Publicacion> filtrar(String pais, String ciudad, LocalDateTime checkIn,
                              LocalDateTime checkOut, Integer adultos,
                              String categoria, List<String> etiquetas);


    @Query("""
    SELECT p
    FROM Publicacion p
    WHERE p.id IN :publisIds
      AND p.id NOT IN :reservadas
""")
    List<Publicacion> obtenerTodosExcepto(@Param("publisIds") List<Long> publisIds,
                                          @Param("reservadas") List<Long> reservadas);




}
