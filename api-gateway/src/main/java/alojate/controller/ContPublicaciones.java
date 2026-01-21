package alojate.controller;

import alojate.service.Microservicios;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping
//@CrossOrigin("http://localhost:8090")
public class ContPublicaciones {
//
////    private final RouteLocatorBuilder routeLocatorBuilder;
//    private final Microservicios microServ;
//
//    public ContPublicaciones(Microservicios servPublicaciones) {
//        this.microServ = servPublicaciones;
//    }
////
////    public ContPublicaciones(RouteLocatorBuilder routeLocatorBuilder, ServPublicaciones servPublicaciones) {
////        this.routeLocatorBuilder = routeLocatorBuilder;
////        this.servPublicaciones = servPublicaciones;
////    }
//
////    @GetMapping("/api/mensaje")
////    public String publicaciones() {
////        System.out.println("publicaciones ha recibido la request de gateway");
////        return "Hola desde publicaciones!";
////    }
//
//    @GetMapping("/alojate/publicaciones")
//    // Ahora sin parámetros, pero esta request debe realizarse con fecha y destino
//    public RouteLocator obtener() {
//        System.out.println("publicaciones en GATEWAY");
//        return microServ.publicaciones();
//    }
////
////    @PostMapping("/alojate/publicaciones")
////    public RouteLocator cargar(){
////        return servPublicaciones.cargar(routeLocatorBuilder);
////    }
}
//
//
