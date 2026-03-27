package alojate.models.repository;


import alojate.models.entities.publicacion.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IReposReserva extends JpaRepository<Reserva, Long> {

//    @Query("""
//        SELECT r.publicacion.id FROM Reserva r
//        WHERE r.publicacion.id IN :ids
//    """)
//    List<Long> obtenerReservadasii(@Param("ids") List<Long> ids);

    @Query("""
    SELECT DISTINCT r.publicacion.id
    FROM Reserva r
    WHERE r.checkIn < :checkOut
      AND r.checkOut > :checkIn
""")
    List<Long> obtenerReservadas(LocalDate checkIn, LocalDate checkOut);


}
