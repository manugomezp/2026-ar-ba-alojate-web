package alojate.usuarios.service;

import alojate.models.dtos.UsuarioDTO;
import alojate.models.entities.usuario.Usuario;
import alojate.models.repository.IReposNacionalidad;
import alojate.models.repository.IReposUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuario {

    private final IReposUsuario reposUsuario;
    private final IReposNacionalidad reposNacionalidad;


    public ServiceUsuario(IReposUsuario reposUsuario, IReposNacionalidad reposNacionalidad) {
        this.reposUsuario = reposUsuario;
        this.reposNacionalidad = reposNacionalidad;
    }

    public void alta(UsuarioDTO dto){
        Usuario usuario = new Usuario();

        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setUrlFoto(dto.getUrlFoto());
        usuario.setFechaNac(dto.getFechaNac());
        usuario.setNacionalidad(reposNacionalidad.findByNacionalidad(dto.getNacionalidad()));

        reposUsuario.save(usuario);
    }
}
