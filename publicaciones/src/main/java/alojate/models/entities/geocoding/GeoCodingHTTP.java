package alojate.models.entities.geocoding;

import alojate.models.entities.publicacion.Ubicacion;
import lombok.Data;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


//@Component
@Data
public class GeoCodingHTTP implements GeoCoding{

    private final WebClient webClient;
    private final String apiKey = "ee9f5e734c6c4729ac3d8f87703bf5df";

    public GeoCodingHTTP(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.geoapify.com").build();
    }


    // La estructura de la respuesta es de una lista de dos elementos: results y query.
    // Para obtener la longitud y latitud debo ingresar al elemento results.
    @Override
    public Mono<LatLonDTO> obtener(Ubicacion ubicacion) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/geocode/search")
                        .queryParam("country", ubicacion.getPais())
                        .queryParam("city", ubicacion.getCiudad())
                        .queryParam("street", ubicacion.getCalle())
                        .queryParam("housenumber", ubicacion.getAltura())
                        .queryParam("postcode", ubicacion.getCodigoPostal())
                        .queryParam("limit", 1)
                        .queryParam("format", "json")
                        .queryParam("apiKey", apiKey)
                        .build()
                )
                .retrieve()
                .bodyToMono(GeoResponseDTO.class)
                .flatMap(response -> {
                    if (response.getResults() == null || response.getResults().isEmpty()) {
                        return Mono.empty();
                    }
                    LatLonDTO r = response.getResults().get(0);
                    return Mono.just(new LatLonDTO(r.getLat(), r.getLon()));
                });
    }



}

