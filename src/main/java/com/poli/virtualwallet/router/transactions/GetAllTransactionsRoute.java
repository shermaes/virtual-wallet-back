package com.poli.virtualwallet.router.transactions;

import com.poli.virtualwallet.usecase.transactions.GetAllTransactionsUseCase;
import com.poli.virtualwallet.dto.TransactionsDTO;
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
public class GetAllTransactionsRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllTransactions (GetAllTransactionsUseCase useCase) {
        return route(GET("/api/get/transactions"),
                request -> ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.apply(), TransactionsDTO.class)));
    }
}
