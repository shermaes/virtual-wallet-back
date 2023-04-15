package com.poli.virtualwallet.repository;

import com.poli.virtualwallet.collection.Transactions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ITransactionsRepository extends ReactiveMongoRepository<Transactions, String> {
}
