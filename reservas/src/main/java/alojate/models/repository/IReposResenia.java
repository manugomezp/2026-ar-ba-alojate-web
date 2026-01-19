package alojate.models.repository;

import alojate.models.entities.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposResenia extends JpaRepository<Resenia,Long> {
}
