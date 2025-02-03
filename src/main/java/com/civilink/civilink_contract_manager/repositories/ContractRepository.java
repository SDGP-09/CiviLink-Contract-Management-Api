package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
