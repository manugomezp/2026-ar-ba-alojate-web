package alojate.models.repository;

import alojate.models.entities.publicacion.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposCategoria extends JpaRepository<Categoria, Long> {
}
