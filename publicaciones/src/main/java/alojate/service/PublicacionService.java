package alojate.service;

import alojate.config.RabbitMQConfig;
import alojate.models.dtos.input.PublicacionDTO;
import alojate.models.dtos.input.QueryParamsPublicacion;
import alojate.events.ReservaEvent;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.models.entities.geocoding.GeoCoding;
import alojate.models.entities.geocoding.GeoCodingHTTP;
import alojate.models.entities.publicacion.Multimedia;
import alojate.models.entities.publicacion.Publicacion;
import alojate.models.entities.publicacion.Reserva;
import alojate.models.entities.publicacion.Ubicacion;
import alojate.models.repository.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublicacionService {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;
    private final IReposPublicacion reposPublicacion;
    private final IUbicacionRepos reposUbicacion;
    private final IReposCategoria reposCategoria;
    private final IReposReserva reposReserva;
    private final IRepoMultimedia iRepoMultimedia;

    private final GeoCoding geoCoding;

    public PublicacionService(DiscoveryClient discoveryClient, RestClient.Builder builder, IReposPublicacion reposPublicacion, IUbicacionRepos reposUbicacion, IReposCategoria reposCategoria, IReposReserva reposReserva, IRepoMultimedia iRepoMultimedia) {
        this.discoveryClient = discoveryClient;
        this.restClient = builder
                .baseUrl("http://localhost:8090")
                .build();
        this.reposPublicacion = reposPublicacion;
        this.reposUbicacion = reposUbicacion;
        this.reposCategoria = reposCategoria;
        this.reposReserva = reposReserva;
        this.iRepoMultimedia = iRepoMultimedia;
        WebClient.Builder geoBuilder = WebClient.builder();
        this.geoCoding = new GeoCodingHTTP(geoBuilder);
    }


    public void alta(PublicacionDTO dto) {
        if (dto == null){
            return;
        }

        Publicacion p = new Publicacion();
        Ubicacion u = new Ubicacion(dto.getCalle(), dto.getAltura(), dto.getCodigoPostal(), dto.getPais(), dto.getCiudad());

        u.obtenerCoordenadas(geoCoding);
        reposUbicacion.save(u);

        p.setTitulo(dto.getTitulo());
        p.setUbicacion(u);
        p.setAnfitrion_id(dto.getAnfitrion_id());
        p.setCantidad_adultos_maxima(dto.getCapacidad());
        p.setDescripcion(dto.getDescripcion());
        p.setCostoPorNoche(dto.getCostoPorNoche());
        p.setHoraDeEntrada(dto.getHoraDeEntrada());
        p.setHoraDeSalida(dto.getHoraDeSalida());
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
        reposPublicacion.save(p);
    }
    public List<Publicacion> obtenerNoReservadas(QueryParamsPublicacion filtro, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        List<Publicacion> publis = reposPublicacion.filtrar(filtro.getPais(), filtro.getCiudad(), checkInDateTime,
                checkOutDateTime, filtro.getAdultos(), filtro.getAmbientes());

        List<Long> publisReservadas = reposReserva.obtenerReservadas(publis.stream().map(Publicacion::getId).toList());

        List<Long> publisIdsDispo = publis.stream()
                .map(Publicacion::getId)
                .filter(id -> publisReservadas.stream().noneMatch(res -> res.equals(id)))
                .toList();

        return reposPublicacion.findAllById(publisIdsDispo);
    }

    public List<OutPublicacionSimple> obtener(QueryParamsPublicacion filtro) {
        // TODO CONSIDERAR EL CASO EN EL QUE EL FILTRO TENGA VALORES NULOS //
        LocalDate checkInDate = LocalDate.parse(filtro.getCheckIn());
        LocalDate checkOutDate = LocalDate.parse(filtro.getCheckOut());
        LocalDateTime checkInDateTime = checkInDate.atTime(14, 0);
        LocalDateTime checkOutDateTime = checkOutDate.atTime(11, 0);
        System.out.println("ESTOY POR DEVOLVER LAS PUBLICACIONES CAPO.");

        return obtenerNoReservadas(filtro,checkInDateTime,checkOutDateTime ).stream().map(this::toOutPublicacionSimple).toList();
    }

    public OutPublicacionSimple toOutPublicacionSimple(Publicacion p){
//        System.out.println("LATITUD"+ p.getUbicacion().getLatitud().toString());
//        System.out.println("LONGITUD" + p.getUbicacion().getLongitud().toString());

        return new OutPublicacionSimple(
                p.getId(),
                p.getMultimedia().stream().map(Multimedia::getId).toList(),
                p.getPuntaje(),
                p.getDivisa().getNombre() + p.getCostoPorNoche().toString(),
                p.getTitulo(),
                p.getCategoria().getNombre(),
                p.getUbicacion().calleAlturaCiudadPais()
        );
    }
    public String getImageById(Long id){
        System.out.println(iRepoMultimedia.findUrlBy(id));
        return iRepoMultimedia.findUrlBy(id);
    }
    public List<String> obtenerDisponibles(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("reservas").get(0);
        return restClient.get()
                .uri(serviceInstance.getUri() + "/api/publicaciones-reservadas")
                .retrieve()
                .body(new ParameterizedTypeReference<List<String>>() {});
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PUBLICACIONES)
    public void onReservaCreada(ReservaEvent event) {
        System.out.println("Reserva recibida: " + event);

       Publicacion publicacion = reposPublicacion
                .findById(Long.parseLong(event.getPublicacion_id()))
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

       System.out.println("ESTOY CONSUMIENDO LA COLA DE RESERVAS");

       reposReserva.save(new Reserva(publicacion, event.getDesde(), event.getHasta()));
    }




}
