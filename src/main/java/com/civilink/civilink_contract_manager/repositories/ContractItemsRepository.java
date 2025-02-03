package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.ContractItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractItemsRepository extends MongoRepository<ContractItems, String> {
}
