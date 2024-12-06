package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantProjectDto;
import com.civilink.civilink_contract_manager.entities.Consultant;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.ConsultantRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultantServiceImpl implements ConsultantService {

    private final ConsultantRepository consultantRepository;

    private final ProjectRepository projectRepository;

    @Override
    public void createConsultant(RequestConsultantDto requestConsultantDto) {
        Consultant consultant = Consultant.builder()
                .id(requestConsultantDto.getId())
                .name(requestConsultantDto.getName())
                .Specializations(requestConsultantDto.getSpecializations())
                .build();
    }

    @Override
    public void addProjectToConsultant(RequestConsultantProjectDto requestConsultantProjectDto) {
        Consultant consultant = consultantRepository.findById(requestConsultantProjectDto.getConsultantId()).get();
        Project project = projectRepository.findById(requestConsultantProjectDto.getProjectId()).get();

        consultant.getProjects().add(project);

        project.setConsultant(consultant);

        projectRepository.save(project);
        consultantRepository.save(consultant);
    }
}
