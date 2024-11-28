package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectDto;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public void createProject(RequestProjectDto requestProjectDto) {

        Project project = Project.builder()
                .projectCategory(requestProjectDto.getProjectCategory())
                .projectEndDate(requestProjectDto.getProjectEndDate())
                .projectName(requestProjectDto.getProjectName())
                .projectStartDate(requestProjectDto.getProjectStartDate())
                .projectDescription(requestProjectDto.getProjectDescription())
                .projectNumber(requestProjectDto.getProjectNumber())
                .projectStatus(requestProjectDto.getProjectStatus())
                .projectId(requestProjectDto.getProjectId())
                .bid(null)
                .build();

        projectRepository.save(project);

    }
}
