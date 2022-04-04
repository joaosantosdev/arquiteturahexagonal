package br.com.ourmind.apigateway.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path( "/person-microservice/**")
                        .filters(f -> f.rewritePath("^/person-microservice", ""))
                        .uri("lb://PERSON-MICROSERVICE"))
                .build();
    }
}
