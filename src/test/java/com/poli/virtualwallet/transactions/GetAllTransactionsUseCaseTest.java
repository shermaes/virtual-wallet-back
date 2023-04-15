package com.poli.virtualwallet.transactions;

import com.poli.virtualwallet.collection.Transactions;
import com.poli.virtualwallet.dto.TransactionsDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import com.poli.virtualwallet.repository.ITransactionsRepository;
import com.poli.virtualwallet.usecase.transactions.GetAllTransactionsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class GetAllTransactionsUseCaseTest {

    private GetAllTransactionsUseCase useCase;
    @Autowired
    private WalletMapper mapper;
    @Mock
    ITransactionsRepository repository;

    @BeforeEach
    public void setUp() {
        useCase = new GetAllTransactionsUseCase(repository, mapper);
    }

    @Test
    public void getAllTransactionsTest() {
        Transactions transaction1 = new Transactions();
        Transactions transaction2 = new Transactions();
        Transactions transaction3 = new Transactions();
        transaction1.setId("01");
        transaction1.setSource("admin");
        transaction1.setReceiver("collaborator1");
        transaction1.setAmount(100.0);
        transaction1.setDate("28/06/2022");

        transaction2.setId("02");
        transaction2.setSource("collaborator2");
        transaction2.setReceiver("collaborator1");
        transaction2.setAmount(200.0);
        transaction2.setDate("28/06/2022");

        transaction3.setId("03");
        transaction3.setSource("collaborator2");
        transaction3.setReceiver("collaborator3");
        transaction3.setAmount(300.0);
        transaction3.setDate("28/06/2022");

        Mockito.when(repository.findAll()).thenReturn(Flux.just(transaction1, transaction2, transaction3));
        Flux<TransactionsDTO> flux = useCase.apply();

        StepVerifier.create(flux).expectNextCount(3).verifyComplete();

        Mockito.verify(repository).findAll();
    }
}
