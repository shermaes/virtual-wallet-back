package com.poli.virtualwallet.router.transactions;

import com.poli.virtualwallet.usecase.transactions.PostTransactionUseCase;
import com.poli.virtualwallet.dto.TransactionsDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostTransactionsRoute {
    @Bean
    public RouterFunction<ServerResponse> postTransaction (PostTransactionUseCase useCase) {
        return route(POST("/api/post/transaction").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TransactionsDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
