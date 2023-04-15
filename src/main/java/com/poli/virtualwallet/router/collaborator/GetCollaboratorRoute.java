package com.poli.virtualwallet.router.collaborator;

import com.poli.virtualwallet.dto.CollaboratorDTO;
import com.poli.virtualwallet.usecase.collaborator.GetCollaboratorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCollaboratorRoute {
@Bean
    public RouterFunction<ServerResponse> allCollaborators(GetCollaboratorUseCase get) {
        return route(GET("/api/get/collaborator"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), CollaboratorDTO.class))
        );
    }
}
