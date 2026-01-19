package alojate.models.repository;

import alojate.models.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposReserva extends JpaRepository<Reserva,Long> {
}
