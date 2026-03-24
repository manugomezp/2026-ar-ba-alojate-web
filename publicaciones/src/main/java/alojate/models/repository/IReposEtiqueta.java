package alojate.models.repository;

import alojate.models.entities.publicacion.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposEtiqueta extends JpaRepository<Etiqueta, Long> {

    Etiqueta getByNombre(String nombre);
}
