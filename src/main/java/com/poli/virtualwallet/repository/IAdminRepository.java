package com.poli.virtualwallet.repository;

import com.poli.virtualwallet.collection.Admin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IAdminRepository extends ReactiveMongoRepository<Admin, String> {
}
