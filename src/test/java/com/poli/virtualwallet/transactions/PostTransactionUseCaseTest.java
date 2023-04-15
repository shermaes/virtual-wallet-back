package com.poli.virtualwallet.transactions;

import com.poli.virtualwallet.collection.Transactions;
import com.poli.virtualwallet.dto.TransactionsDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import com.poli.virtualwallet.repository.ITransactionsRepository;
import com.poli.virtualwallet.usecase.transactions.PostTransactionUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class PostTransactionUseCaseTest {

    private PostTransactionUseCase useCase;
    @Autowired
    private WalletMapper mapper;
    @Mock
    ITransactionsRepository repository;

    @BeforeEach
    public void setUp() {
        useCase = new PostTransactionUseCase(repository, mapper);
    }

    @Test
    public void postTransactionTest() {

        Transactions transaction1 = new Transactions();
        transaction1.setId("01");
        transaction1.setSource("admin");
        transaction1.setReceiver("collaborator1");
        transaction1.setAmount(100.0);
        transaction1.setDate("28/06/2022");

        TransactionsDTO transaction1DTO = new TransactionsDTO();
        transaction1DTO.setId("01");
        transaction1DTO.setSource("admin");
        transaction1DTO.setReceiver("collaborator1");
        transaction1DTO.setAmount(100.0);
        transaction1DTO.setDate("28/06/2022");

        Mockito.when(repository.save(transaction1)).thenReturn(Mono.just(transaction1));

        //El useCase guardara una transaccion y nos devolvera un dto
        StepVerifier.create(useCase.apply(transaction1DTO)).expectNext(transaction1DTO).verifyComplete();

        Mockito.verify(repository).save(transaction1);
    }
}
