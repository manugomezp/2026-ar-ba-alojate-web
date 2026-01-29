package alojate.models.repository;


import alojate.models.entities.publicacion.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReposReserva extends JpaRepository<Reserva, Long> {

    @Query("""
        SELECT r.publicacion.id FROM Reserva r
        WHERE r.publicacion.id IN :ids
    """)
    List<Long> obtenerReservadas(@Param("ids") List<Long> ids);


}
