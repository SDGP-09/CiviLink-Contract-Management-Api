package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}
