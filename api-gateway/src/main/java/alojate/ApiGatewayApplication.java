package alojate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
    //testeo
    // Haciendo un GET a http://localhost/8080 se solicita a este módulo
    // acceso a http://httpbin.org:80; de forma analóga a como funciona un gateway
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
//                .build();
//    }
//





}
