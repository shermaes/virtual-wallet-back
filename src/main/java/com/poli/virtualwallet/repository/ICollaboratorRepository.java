package com.poli.virtualwallet.repository;

import com.poli.virtualwallet.collection.Collaborator;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICollaboratorRepository extends ReactiveMongoRepository<Collaborator, String> {
}
