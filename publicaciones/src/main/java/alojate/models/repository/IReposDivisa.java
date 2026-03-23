package alojate.models.repository;

import alojate.models.entities.publicacion.Divisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReposDivisa extends JpaRepository<Divisa,Long> {


    Divisa getByNombre(String nombre);

}
