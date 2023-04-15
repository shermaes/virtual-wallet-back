package com.poli.virtualwallet.usecase.transactions;

import com.poli.virtualwallet.repository.ITransactionsRepository;
import com.poli.virtualwallet.dto.TransactionsDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetTransactionOutUseCase {
    private ITransactionsRepository repository;
    private WalletMapper mapper;

    public GetTransactionOutUseCase(ITransactionsRepository repository, WalletMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<TransactionsDTO> apply (String email) {
        return repository.findAll().filter(transactions -> email.equals(transactions.getSource()))
                .map(transactions -> mapper.toTransactionsDTO(transactions));
    }
}
