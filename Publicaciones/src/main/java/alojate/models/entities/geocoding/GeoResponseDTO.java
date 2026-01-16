package alojate.models.entities.geocoding;

import lombok.Data;

import java.util.List;

@Data
public class GeoResponseDTO {
    private List<LatLonDTO> results;
}
