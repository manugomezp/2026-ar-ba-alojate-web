import alojate.models.entities.geocoding.GeoCoding;
import alojate.models.entities.geocoding.GeoCodingHTTP;
import alojate.models.entities.publicacion.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

//@SpringBootTest
public class GeoCodingTest {

    private  GeoCoding geoCoding;

    @BeforeEach
    void setUp() {
        WebClient.Builder builder = WebClient.builder();
        this.geoCoding = new GeoCodingHTTP(builder);
    }


    @Test
    public void asignarCoordenadas() {

        Ubicacion ubicacion = new Ubicacion("Avenida La Plata", "1700", "1250", "Buenos Aires", "Argentina");
        ubicacion.obtenerCoordenadas(geoCoding);

        System.out.println(ubicacion.getLongitud());
        System.out.println(ubicacion.getLatitud());

        Assertions.assertNotNull(ubicacion.getLatitud());
        Assertions.assertNotNull(ubicacion.getLongitud());

    }

}
