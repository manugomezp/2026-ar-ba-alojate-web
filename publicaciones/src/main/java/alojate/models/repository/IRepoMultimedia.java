package alojate.models.repository;

import alojate.models.entities.publicacion.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoMultimedia extends JpaRepository<Multimedia,Long> {
    @Query("""
        SELECT mm.url FROM Multimedia mm
        WHERE (:id = mm.id)
    """)
    String findUrlBy(Long id);
}
