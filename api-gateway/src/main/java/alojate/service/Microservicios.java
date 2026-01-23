package alojate.service;


import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Service;


//@Service
public class Microservicios {

//    private final RouteLocatorBuilder builder;
//
//    public Microservicios( RouteLocatorBuilder builder) {
//        this.builder = builder;
//    }

//    @Bean
//    public RouteLocator publicaciones() {
//        return builder.routes()
//                .route("publicaciones_route", r -> r
//                        .path("/alojate/publicaciones/**")
//                        .filters(f -> f
//                                .rewritePath(
//                                        "/alojate/publicaciones/(?<segment>.*)",
//                                        "/api/publicaciones${segment}"
//                                )
//                        )
//                        .uri("http://localhost:8090")
//                )
//                .build();
//    }
//
//    @Bean
//    public RouteLocator reservas() {
//        return builder.routes()
//                .route("reservas_route", r -> r
//                        .path("/alojate/reservas/**")
//                        .filters(f -> f
//                                .rewritePath(
//                                        "/alojate/reservas/(?<segment>.*)",
//                                        "/api/reservas${segment}"
//                                )
//                        )
//                        .uri("http://localhost:9000")
//                )
//                .build();
//    }
//
//    @Bean
//    public RouteLocator usuarios() {
//        return builder.routes()
//                .route("usuarios_route", r -> r
//                        .path("/alojate/usuarios/**")
//                        .filters(f -> f
//                                .rewritePath(
//                                        "/alojate/usuarios/(?<segment>.*)",
//                                        "/api/usuarios${segment}"
//                                )
//                        )
//                        .uri("http://localhost:9020")
//                )
//                .build();
//    }





}
