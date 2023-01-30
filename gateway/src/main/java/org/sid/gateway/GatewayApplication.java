package org.sid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ReactiveAdapter;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    // static mapping
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r->r.path("/customer/**").uri("lb://CUSTOMER-SERVICE"))
//                .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
//                .build();
//    }

    // Dynamic mapping
    @Bean
    DiscoveryClientRouteDefinitionLocator routes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

}
