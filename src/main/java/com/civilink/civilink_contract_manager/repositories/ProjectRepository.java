package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Long> {

}
