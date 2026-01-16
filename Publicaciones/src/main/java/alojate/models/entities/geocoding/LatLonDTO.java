package alojate.models.entities.geocoding;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LatLonDTO {
    @JsonProperty("lon")
    Double lon;
    @JsonProperty("lat")
    Double lat;

    public LatLonDTO(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }
}
