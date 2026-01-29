package alojate.models.repository;

import alojate.models.entities.Resenia;
import alojate.models.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReposResenia extends JpaRepository<Resenia,Long> {

    @Query("""
       SELECT r FROM Resenia r
       WHERE r.reserva IN :reservas
       """)
    List<Resenia> findAllByReservas(@Param("reservas") List<Reserva> reservas);
}
