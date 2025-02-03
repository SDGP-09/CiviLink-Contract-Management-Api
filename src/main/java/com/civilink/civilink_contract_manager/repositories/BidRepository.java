package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidRepository extends MongoRepository<Bid, String> {

}
