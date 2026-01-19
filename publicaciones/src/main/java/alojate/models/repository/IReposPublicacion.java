package alojate.models.repository;


import alojate.models.entities.publicacion.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposPublicacion extends JpaRepository<Publicacion, Long> {


}
