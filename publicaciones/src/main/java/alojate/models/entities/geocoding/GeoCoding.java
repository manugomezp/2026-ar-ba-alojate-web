package alojate.models.entities.geocoding;

import alojate.models.entities.publicacion.Ubicacion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Component
public interface GeoCoding {
   Mono<LatLonDTO> obtener(Ubicacion ubicacion);

}
