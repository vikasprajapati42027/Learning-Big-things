package com.example.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class FunctionalConfig {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/functional/hello"),
            request -> ServerResponse.ok().bodyValue("Hello from Functional Web!"));
    }
}
