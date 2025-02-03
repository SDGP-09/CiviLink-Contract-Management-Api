package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
