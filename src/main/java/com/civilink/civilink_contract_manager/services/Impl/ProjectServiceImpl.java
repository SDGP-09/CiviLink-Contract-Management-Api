package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectFindByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectUpdateDto;
import com.civilink.civilink_contract_manager.entities.Client;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.ClientRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ClientRepository clientRepository;



    @Override
    public void createProject(RequestProjectDto requestProjectDto) {

        Client client = clientRepository.findById(Integer.valueOf(requestProjectDto.getClientId())).get();

        Project project = Project.builder()
                .projectCategory(requestProjectDto.getProjectCategory())
                .projectEndDate(requestProjectDto.getProjectEndDate())
                .projectName(requestProjectDto.getProjectName())
                .projectStartDate(requestProjectDto.getProjectStartDate())
                .projectDescription(requestProjectDto.getProjectDescription())
                .projectNumber(requestProjectDto.getProjectNumber())
                .projectStatus(requestProjectDto.getProjectStatus())
                .id(Long.parseLong(requestProjectDto.getId()))
                .client(client)
                .build();

        projectRepository.save(project);

    }

    @Override
    public void updateProject(RequestProjectUpdateDto requestProjectUpdateDto) {
        RequestProjectFindByIdDto requestProjectFindByIdDto = new RequestProjectFindByIdDto(requestProjectUpdateDto.getId());
        Project project = projectRepository.findById(Long.valueOf(requestProjectFindByIdDto.getId())).get();

        project.setProjectCategory(requestProjectUpdateDto.getProjectCategory());
        project.setProjectEndDate(requestProjectUpdateDto.getProjectEndDate());
        project.setProjectName(requestProjectUpdateDto.getProjectName());
        project.setProjectStartDate(requestProjectUpdateDto.getProjectStartDate());
        project.setProjectDescription(requestProjectUpdateDto.getProjectDescription());
        project.setProjectNumber(requestProjectUpdateDto.getProjectNumber());
        project.setProjectStatus(requestProjectUpdateDto.getProjectStatus());
        project.setId(Long.parseLong(requestProjectFindByIdDto.getId()));
        projectRepository.save(project);


    }

    @Override
    public Project findById(RequestProjectFindByIdDto requestProjectFindByIdDto) {
        Optional<Project> optional =  projectRepository.findById(Long.valueOf(requestProjectFindByIdDto.getId()));

        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
