package alojate.service;

import alojate.models.dtos.input.PublicacionDTO;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.models.entities.geocoding.GeoCoding;
import alojate.models.entities.geocoding.GeoCodingHTTP;
import alojate.models.entities.publicacion.Publicacion;
import alojate.models.entities.publicacion.Ubicacion;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionService {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;
    public List<Publicacion> publicacionesDisponibles = new ArrayList<Publicacion>();
    private final GeoCoding geoCoding;

    public PublicacionService(DiscoveryClient discoveryClient, RestClient.Builder builder) {
        this.discoveryClient = discoveryClient;
        this.restClient = builder
                .baseUrl("http://localhost:8090")
                .build();
        WebClient.Builder geoBuilder = WebClient.builder();
        this.geoCoding = new GeoCodingHTTP(geoBuilder);
    }

    public OutPublicacionSimple toOutPublicacionSimple(Publicacion p){
        System.out.println("LATITUD"+ p.getUbicacion().getLatitud().toString());
        System.out.println("LONGITUD" + p.getUbicacion().getLongitud().toString());

        return new OutPublicacionSimple(
                "Una foto de la casa",
                p.getPuntaje(),
                "USD" + p.getCostoPorNoche().toString(),
                p.getTitulo(),
                "CASA"
                );
    }
    public void alta(PublicacionDTO dto) {
        if (dto == null){
            return;
        }

        Publicacion p = new Publicacion();
        Ubicacion u = new Ubicacion(dto.getCalle(), dto.getAltura(), dto.getCodigoPostal(), dto.getPais(), dto.getCiudad());
        u.obtenerCoordenadas(geoCoding);

        p.setTitulo(dto.getTitulo());
        p.setUbicacion(u);
        p.setAnfitrion_id(dto.getAnfitrion_id());
        p.setCapacidad(dto.getCapacidad());
        p.setDescripcion(dto.getDescripcion());
        p.setCostoPorNoche(dto.getCostoPorNoche());
        p.setCheckIn(dto.getCheckIn());
        p.setCheckOut(dto.getCheckOut());
        p.setCancelacionGratuita(dto.getCancelacionGratuita());
        p.setValidaDesde(dto.getValidaDesde());
        p.setValidaHasta(dto.getValidaHasta());

//        // String -> Enum (se asume válido o null)
//        p.setCategoria(dto.getCategoria() != null
//                ? IReposCategoria.valueOf(dto.getCategoria())
//                : null);
//
//        p.setDivisa(dto.getDivisa() != null
//                ? Divisa.valueOf(dto.getDivisa())
//                : null);
//
//        p.setFormaDePago(dto.getFormaDePago() != null
//                ? FormaDePago.valueOf(dto.getFormaDePago())
//                : null);
//
//        // Ubicación
//        p.setUbicacion(dto.getUbicacion() != null
//                ? new Ubicacion(dto.getUbicacion())
//                : null);
//
//        // Multimedia
//        p.setMultimedia(dto.getMultimedia() != null
//                ? dto.getMultimedia()
//                .stream()
//                .map(MultimediaMapper::fromDTO)
//                .toList()
//                : null);

        System.out.println("SE CREO UNA PUBLICACION EN PUBLICACIONES ✔✔✔");
        publicacionesDisponibles.add(p);
    }




    public List<String> obtenerDisponibles(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("reservas").get(0);
        return restClient.get()
                .uri(serviceInstance.getUri() + "/api/publicaciones-reservadas")
                .retrieve()
                .body(new ParameterizedTypeReference<List<String>>() {});
    }




}
