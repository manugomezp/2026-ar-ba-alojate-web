package alojate.models.repository;

import alojate.models.entities.usuario.Nacionalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposNacionalidad extends JpaRepository<Nacionalidad, Long> {
    Nacionalidad findByNacionalidad(String nacionalidad);
}
