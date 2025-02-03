package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.BidItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidItemRepository extends JpaRepository<BidItem, Long> {
}
