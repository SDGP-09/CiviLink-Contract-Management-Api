package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.BidItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidItemRepository extends MongoRepository<BidItem, String> {
}
