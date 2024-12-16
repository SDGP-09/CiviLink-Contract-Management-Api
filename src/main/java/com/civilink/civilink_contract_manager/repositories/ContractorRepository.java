package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Contractor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractorRepository extends MongoRepository<Contractor, String> {
}
