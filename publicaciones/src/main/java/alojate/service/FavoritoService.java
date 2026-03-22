package alojate.service;

import alojate.models.dtos.output.FavoritoDTO;
import alojate.models.entities.publicacion.Favorito;
import alojate.models.entities.publicacion.Publicacion;
import alojate.models.repository.IRepoFavoritos;
import alojate.models.repository.IReposPublicacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    private final IRepoFavoritos iRepoFavorito;
    private final IReposPublicacion reposPublicacion;

    public FavoritoService(IRepoFavoritos iRepoFavorito, IReposPublicacion reposPublicacion) {
        this.iRepoFavorito = iRepoFavorito;
        this.reposPublicacion = reposPublicacion;
    }


    public void agregarFavorito(String user_id, Long pub_id){
        System.out.println("SE ESTÁ POR AGREGAR UN FAVORITO");
        Publicacion publicacion = reposPublicacion.findById(pub_id).get();
        Favorito favorito = new Favorito(user_id, publicacion);
        System.out.println("SE AGREGÓ NOMAS; SU ID ES: " + publicacion.getId());

        iRepoFavorito.save(favorito);
    }
    public List<FavoritoDTO> favoritos(String user_id){
        List<Favorito> favoritos = iRepoFavorito.findAllByUserId(user_id);
        return favoritos.stream().map(this::favToDTO).toList();
    }

    public FavoritoDTO favToDTO(Favorito f){
        FavoritoDTO dto = new FavoritoDTO();
        dto.setPublicacion_nombre(f.getNombre());
        dto.setPuntaje(f.getPuntaje());

        return dto;
    }
}
