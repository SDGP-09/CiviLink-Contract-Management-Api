package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

}
