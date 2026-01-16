package alojate.models.repository;

import alojate.models.entities.formulario.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposFormulario extends JpaRepository<Formulario, Long> {

}
