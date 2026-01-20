package alojate.service;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.List;

@Service
public class PublicacionService {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public PublicacionService(DiscoveryClient discoveryClient, RestClient.Builder builder) {
        this.discoveryClient = discoveryClient;
        this.restClient = builder
                .baseUrl("http://localhost:8090")
                .build();
    }

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

    public List<String> obtenerDisponibles(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("reservas").get(0);
        return restClient.get()
                .uri(serviceInstance.getUri() + "/api/publicaciones-reservadas")
                .retrieve()
                .body(new ParameterizedTypeReference<List<String>>() {});
    }




}
