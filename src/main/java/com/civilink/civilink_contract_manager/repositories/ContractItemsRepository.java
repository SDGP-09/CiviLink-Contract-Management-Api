package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.ContractItems;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContractItemsRepository extends JpaRepository<ContractItems, String> {
}
