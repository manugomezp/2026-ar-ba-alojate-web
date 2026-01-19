package alojate.service;

import alojate.models.entities.publicacion.Publicacion;
import alojate.models.repository.IReposPublicacion;
import alojate.models.dtos.input.PublicacionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PublicacionService {

//    private final IReposPublicacion reposPublicacion;
//    public PublicacionService(IReposPublicacion reposPublicacion) {
//        this.reposPublicacion = reposPublicacion;
//    }
//
//    public void alta(PublicacionDTO dto){
//        Publicacion publicacion = new Publicacion();
//
//        publicacion.setTitulo(dto.getTitulo());
//        publicacion.setDescripcion(dto.getDescripcion());
//        //publicacion.setCategoria(reposCategoria.findByTipo(dto.getCategoria()));
//        publicacion.setCapacidad(dto.getCapacidad());
//        publicacion.setCheckIn(dto.getCheckIn());
//        publicacion.setCheckOut(dto.getCheckOut());
//        //publicacion.setDivisa(reposDivisa.findByTipo(dto.getDivisa()));
//        publicacion.setFecha(LocalDateTime.now());
//        publicacion.setValidaDesde(dto.getValidaDesde());
//        publicacion.setValidaHasta(dto.getValidaHasta());
//        publicacion.setCostoPorNoche(dto.getCostoPorNoche());
//        publicacion.setCancelacionGratuita(dto.getCancelacionGratuita());
//        publicacion.setAnfitrion_id(dto.getAnfitrion_id());
//
//        // RESTA UBICACION Y FORMA DE PAGO.
//
//        reposPublicacion.save(publicacion);
//    }





}
