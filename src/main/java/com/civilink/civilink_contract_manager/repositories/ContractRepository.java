package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<Contract, String> {
}
