package alojate.models.repository;

import alojate.models.entities.publicacion.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepoFavoritos extends JpaRepository<Favorito, Long> {

    List<Favorito> findAllByUserId(String userId);
}
