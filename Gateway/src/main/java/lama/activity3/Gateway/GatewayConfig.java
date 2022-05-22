package lama.activity3.Gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("http://localhost:8081"))
                .route("cards", r -> r.path("/players/**").filters(f -> f.filter(filter)).uri("http://localhost:8082"))
                .route("players", r -> r.path("/players/**").filters(f -> f.filter(filter)).uri("http://localhost:8083"))
                .route("market", r -> r.path("/players/**").filters(f -> f.filter(filter)).uri("http://localhost:8084"))
                .route("games", r -> r.path("/players/**").filters(f -> f.filter(filter)).uri("http://localhost:8085"))
                .route("rooms", r -> r.path("/players/**").filters(f -> f.filter(filter)).uri("http://localhost:8086"))
                .build();
    }

}
