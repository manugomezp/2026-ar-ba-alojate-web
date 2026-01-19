package alojate.service;

import alojate.models.dtos.input.FormularioDTO;
import alojate.models.dtos.input.PreguntaDTO;
import alojate.models.entities.formulario.Formulario;
import alojate.models.entities.formulario.Pregunta;
import alojate.models.repository.ReposFormulario;
import alojate.models.repository.ReposPregunta;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdministrativo {

    private final ReposPregunta reposPregunta;
    private final ReposFormulario reposFormulario;

    public ServiceAdministrativo(ReposPregunta reposPregunta, ReposFormulario reposFormulario) {
        this.reposPregunta = reposPregunta;
        this.reposFormulario = reposFormulario;
    }

    public void altaFormulario(FormularioDTO formularioDTO){
        Formulario formulario = new Formulario();

        formulario.setPreguntas(formularioDTO.getPreguntas().stream().map(this::dtoToPregunta).toList());
        formulario.setTitulo(formularioDTO.getNombre());

        reposFormulario.save(formulario);
    }

    public Pregunta dtoToPregunta(PreguntaDTO preguntaDTO){
        return reposPregunta.findPreguntaById(preguntaDTO.getId());
    }
}
