package alojate.models.repository;

import alojate.models.entities.publicacion.Multimedia;
import alojate.models.entities.publicacion.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepoMultimedia extends JpaRepository<Multimedia,Long> {
    @Query("""
        SELECT mm.url FROM Multimedia mm
        WHERE (:id = mm.id)
    """)
    String findUrlBy(Long id);


    @Query("SELECT m.url FROM Multimedia m WHERE m.publicacion.id = :publicacionId")
    List<String> devolverURLsSegunId(@Param("publicacionId") Long publicacionId);
}
