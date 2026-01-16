package alojate.models.entities.publicacion;

import lombok.Data;

import java.util.List;

@Data
public class FormaDePago {
    private MomentoDePago momentoDePago;
    private Integer pcjeSenia;
    private List<MedioDePago> mediosDePago;

}
