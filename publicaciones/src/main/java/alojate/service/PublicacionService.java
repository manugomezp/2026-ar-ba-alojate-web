package alojate.service;

import alojate.models.dtos.input.PublicacionDTO;
import alojate.models.dtos.input.QueryParamsPublicacion;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.models.entities.geocoding.GeoCoding;
import alojate.models.entities.geocoding.GeoCodingHTTP;
import alojate.models.entities.publicacion.*;
import alojate.models.repository.*;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
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
    private final ImageService imageService;
    private final GeoCoding geoCoding;
    private final IReposDivisa iReposDivisa;
    private final IReposEtiqueta iReposEtiqueta;

    public PublicacionService(DiscoveryClient discoveryClient, RestClient.Builder builder, IReposPublicacion reposPublicacion, IUbicacionRepos reposUbicacion,
                              IReposCategoria reposCategoria, IReposReserva reposReserva, IRepoMultimedia iRepoMultimedia, ImageService imageService, IReposDivisa iReposDivisa, IReposEtiqueta iReposEtiqueta) {
        this.discoveryClient = discoveryClient;
        this.restClient = builder
                .baseUrl("http://localhost:8090")
                .build();
        this.reposPublicacion = reposPublicacion;
        this.reposUbicacion = reposUbicacion;
        this.reposCategoria = reposCategoria;
        this.reposReserva = reposReserva;
        this.iRepoMultimedia = iRepoMultimedia;
        this.imageService = imageService;
        this.iReposDivisa = iReposDivisa;
        WebClient.Builder geoBuilder = WebClient.builder();
        this.geoCoding = new GeoCodingHTTP(geoBuilder);
        this.iReposEtiqueta = iReposEtiqueta;
    }

    public void alta(PublicacionDTO datos, List<MultipartFile> imagenes) throws IOException {
        Publicacion p = this.altaDeDatos(datos);
        reposPublicacion.save(p);
        if (imagenes != null && !imagenes.isEmpty()) {
            List<String> urls = imageService.guardarTodas(imagenes, p.getId());
            almacenarMultimedia(p, urls);
            reposPublicacion.save(p);
        }
    }

    public void almacenarMultimedia(Publicacion publicacion, List<String> urls){
        for(String url : urls){
            iRepoMultimedia.save(new Multimedia(publicacion, url));
        }
    }

    public Publicacion altaDeDatos(PublicacionDTO dto) {
        if (dto == null){
            return null;
        }

        Publicacion p = new Publicacion();
        Ubicacion u = new Ubicacion(dto.getCalle(), dto.getAltura(), dto.getCodigoPostal(), dto.getPais(),  dto.getProvincia(), dto.getCiudad());

        u.obtenerCoordenadas(geoCoding);
        reposUbicacion.save(u);

        p.setAnfitrion_id(dto.getAnfitrion_id());
        p.setCategoria(reposCategoria.getCategoriaBy(dto.getCategoria().toUpperCase()));
        p.setTitulo(dto.getTitulo());
        p.setUbicacion(u);
        p.setAnfitrion_id(dto.getAnfitrion_id());
        p.setCantidad_adultos_maxima(dto.getCapacidad());
        p.setDescripcion(dto.getDescripcion());
        p.setCostoPorNoche(dto.getCostoPorNoche());
        p.setHoraDeEntrada(dto.getHoraDeEntrada());
        p.setHoraDeSalida(dto.getHoraDeSalida());
        p.setValidaDesde(dto.getValidaDesde().atStartOfDay());
        p.setValidaHasta(dto.getValidaHasta().atStartOfDay());
        p.setEstado(Estado.ABIERTA);
        p.setDivisa(iReposDivisa.getByNombre(dto.getDivisa()));

        for(String etiqueta: dto.getEtiquetas()){
            Etiqueta eq = iReposEtiqueta.getByNombre(etiqueta.toUpperCase());
            p.agregarEtiqueta(eq);
        }

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
       // reposPublicacion.save(p);

        return p;
    }

    public PublicacionDTO devolverPublicacion(Long id){
        Publicacion entity = reposPublicacion.findById(id).get();

        PublicacionDTO dto = new PublicacionDTO();

        dto.setPublicacion_id(entity.getId().toString());

        dto.setTitulo(entity.getTitulo());
        dto.setAnfitrion_id(entity.getAnfitrion_id());

        // Relaciones
        dto.setCategoria(
                entity.getCategoria() != null ? entity.getCategoria().getNombre() : null
        );

        if (entity.getUbicacion() != null) {
            dto.setCalle(entity.getUbicacion().getCalle());
            dto.setAltura(entity.getUbicacion().getAltura());
            dto.setPais(entity.getUbicacion().getPais());
            dto.setCodigoPostal(entity.getUbicacion().getCodigoPostal());
            dto.setProvincia(entity.getUbicacion().getProvincia());
            dto.setCiudad(entity.getUbicacion().getCiudad());
        }

        dto.setCapacidad(entity.getCantidad_adultos_maxima());
        dto.setDescripcion(entity.getDescripcion());
        dto.setCostoPorNoche(entity.getCostoPorNoche());

        dto.setDivisa(
                entity.getDivisa() != null ? entity.getDivisa().getNombre() : null
        );

        dto.setFormaDePago(
                entity.getFormaDePago() != null ? entity.getFormaDePago().getMediosDePago().toString() : "EFECTIVO"
        );

        dto.setHoraDeEntrada(entity.getHoraDeEntrada());
        dto.setHoraDeSalida(entity.getHoraDeSalida());

        // Fechas (LocalDateTime → LocalDate)
        dto.setValidaDesde(
                entity.getValidaDesde() != null ? entity.getValidaDesde().toLocalDate() : null
        );

        dto.setValidaHasta(
                entity.getValidaHasta() != null ? entity.getValidaHasta().toLocalDate() : null
        );

        // Etiquetas (si no están en la entidad)
        dto.setEtiquetas(entity.getEtiquetas().stream().map(Etiqueta::getNombre).toList());
        List<String> multimedia =devuelveURLimagenes(entity.getId());
        System.out.println("ESTO ES UNA URL DEL Dto: " + multimedia.get(0));
        dto.setMultimedia(multimedia);
        return dto;

    }



    public List<Publicacion> obtenerNoReservadas(QueryParamsPublicacion filtro, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        List<Publicacion> publis = reposPublicacion.filtrar(filtro.getPais(), filtro.getCiudad(), checkInDateTime,
                checkOutDateTime, filtro.getAdultos(), filtro.getCategoria(), filtro.getEtiquetas());

        List<Long> publisReservadas = reposReserva.obtenerReservadas(checkInDateTime.toLocalDate(), checkOutDateTime.toLocalDate());

        if(publisReservadas.isEmpty())
            return publis;
        return reposPublicacion.obtenerTodosExcepto(publis.stream().map(Publicacion::getId).toList(), publisReservadas);
    }



    public List<OutPublicacionSimple> obtener(QueryParamsPublicacion filtro) {
        // TODO CONSIDERAR EL CASO EN EL QUE EL FILTRO TENGA VALORES NULOS //
        LocalDate checkInDate = LocalDate.parse(filtro.getCheckIn());
        LocalDate checkOutDate = LocalDate.parse(filtro.getCheckOut());
        LocalDateTime checkInDateTime = checkInDate.atTime(14, 0);
        LocalDateTime checkOutDateTime = checkOutDate.atTime(11, 0);
      //  System.out.println("ESTOY POR DEVOLVER LAS PUBLICACIONES CAPO.");

        return obtenerNoReservadas(filtro,checkInDateTime,checkOutDateTime ).stream().map(this::toOutPublicacionSimple).toList();
    }

    public List<String> devuelveURLimagenes(Long id){
        return iRepoMultimedia.devolverURLsSegunId(id)
                .stream()
                .map(m -> "http://localhost:8080/alojate/uploads" + m)
                .toList();
    }

    public OutPublicacionSimple toOutPublicacionSimple(Publicacion p) {
        List<String> urls = devuelveURLimagenes(p.getId());
       // System.out.println("LOG DE UNA URL: " + urls.get(0));


        return new OutPublicacionSimple(
                p.getId(),
                urls,
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






}
