package alojate.models.repository;

import alojate.models.entities.formulario.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposPregunta extends JpaRepository<Pregunta, Long> {
     Pregunta findPreguntaById(Long id);
}
