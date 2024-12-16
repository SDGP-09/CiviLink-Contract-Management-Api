package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.BidResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidResponsesRepository extends MongoRepository<BidResponse, String> {
}
