package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
