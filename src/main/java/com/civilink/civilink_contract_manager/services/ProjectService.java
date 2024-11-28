package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectDto;
import com.civilink.civilink_contract_manager.entities.Project;

public interface ProjectService {
    public void createProject(RequestProjectDto requestProjectDto);
}
