package com.poli.virtualwallet.usecase.transactions;

import com.poli.virtualwallet.repository.ITransactionsRepository;
import com.poli.virtualwallet.dto.TransactionsDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostTransactionUseCase { ;
    private ITransactionsRepository repository;
    private WalletMapper mapper;

    public PostTransactionUseCase(ITransactionsRepository repository, WalletMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<TransactionsDTO> apply (TransactionsDTO dto) {
        return repository.save(mapper.toTransactionsEntity(dto)).map(transactions -> mapper.toTransactionsDTO(transactions));
    } 
}
