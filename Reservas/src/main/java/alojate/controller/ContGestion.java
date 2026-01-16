package alojate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ContGestion {
    private final ServRecorrido servRecorrido;

    public ContGestion(ServRecorrido servRecorrido) {
        this.servRecorrido = servRecorrido;
    }

    @PostMapping("/api/trayectos")
    public void alta(@RequestBody List<TrayectoDTO> trayectos){
        servRecorrido.alta(trayectos);
    }
}
