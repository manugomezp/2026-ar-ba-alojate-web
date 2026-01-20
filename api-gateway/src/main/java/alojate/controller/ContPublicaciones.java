package alojate.controller;

import alojate.service.ServPublicaciones;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:8090")
public class ContPublicaciones {

    private final RouteLocatorBuilder routeLocatorBuilder;
    private final ServPublicaciones servPublicaciones;

    public ContPublicaciones(RouteLocatorBuilder routeLocatorBuilder, ServPublicaciones servPublicaciones) {
        this.routeLocatorBuilder = routeLocatorBuilder;
        this.servPublicaciones = servPublicaciones;
    }

//    @GetMapping("/api/mensaje")
//    public String publicaciones() {
//        System.out.println("publicaciones ha recibido la request de gateway");
//        return "Hola desde publicaciones!";
//    }

    @GetMapping("/publicaciones")
    // Ahora sin parámetros, pero esta request debe realizarse con fecha y destino
    public RouteLocator publicaciones() {
        System.out.println("publicaciones en GATEWAY");
        return servPublicaciones.devolverPublicaciones(routeLocatorBuilder);
    }
}


