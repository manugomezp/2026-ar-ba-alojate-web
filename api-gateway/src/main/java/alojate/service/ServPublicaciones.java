package alojate.service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class ServPublicaciones {

    @Bean
    public RouteLocator devolverPublicaciones(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("publicaciones_route", r -> r
                        .path("/publicaciones/**")
                        .filters(f -> f
                                .rewritePath(
                                        "/publicaciones/(?<segment>.*)",
                                        "/api/publicaciones${segment}"
                                )
                        )
                        .uri("http://localhost:8090")
                )
                .build();
    }


}
