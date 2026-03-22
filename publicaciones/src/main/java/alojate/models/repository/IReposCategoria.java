package alojate.models.repository;

import alojate.models.entities.publicacion.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposCategoria extends JpaRepository<Categoria, Long> {

    @Query("""
       SELECT c
       FROM Categoria c
       WHERE c.nombre = :categoria
       """)
    Categoria getCategoriaBy(@Param("categoria") String categoria);
}
