package com.poli.virtualwallet.router.collaborator;

import com.poli.virtualwallet.dto.CollaboratorDTO;
import com.poli.virtualwallet.usecase.collaborator.PostCollaboratorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostCollaboratorRoute {
    @Bean
    public RouterFunction<ServerResponse> postCollaborator(PostCollaboratorUseCase postCollaboratorUseCase) {
        return route(POST("/api/post/collaborator").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CollaboratorDTO.class)
                        .flatMap(collaboratorDTO -> postCollaboratorUseCase.apply(collaboratorDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
