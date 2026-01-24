package alojate.models.repository;

import alojate.models.entities.publicacion.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUbicacionRepos extends JpaRepository<Ubicacion, Long> {
}
