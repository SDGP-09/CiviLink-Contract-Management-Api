package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseClientDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseConsultantAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseConsultantDto;
import com.civilink.civilink_contract_manager.entities.Client;
import com.civilink.civilink_contract_manager.entities.Consultant;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.exception.ClientNotFoundException;
import com.civilink.civilink_contract_manager.exception.ConsultantNotFoundException;
import com.civilink.civilink_contract_manager.repositories.ConsultantRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .specializations(requestConsultantDto.getSpecializations())
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

    @Override
    public ResponseConsultantDto update(RequestConsultantUpdateDto requestConsultantUpdateDto) throws ConsultantNotFoundException {
        Consultant consultant = consultantRepository.findById(requestConsultantUpdateDto.getId()).orElse(null);

        if (consultant == null){
            throw new ConsultantNotFoundException("Consultant not found with the id of: " + requestConsultantUpdateDto.getId());
        }

        if (requestConsultantUpdateDto.getName() != null) consultant.setName(requestConsultantUpdateDto.getName());
        if (requestConsultantUpdateDto.getSpecializations() != null) consultant.setSpecializations(requestConsultantUpdateDto.getSpecializations());
        if (requestConsultantUpdateDto.getProjectsList() != null) {
            List<Project> updatedProjects = requestConsultantUpdateDto.getProjectsList()
                    .stream()
                    .map(project -> projectRepository.save(project))
                    .toList();
            consultant.setProjects(updatedProjects);
        }

        Consultant updatedConsultant = consultantRepository.save(consultant);
        return new ResponseConsultantDto(updatedConsultant);
    }

    @Override
    public ResponseConsultantDto findById(RequestConsultantByIdDto requestConsultantByIdDto) throws ConsultantNotFoundException {

        Consultant consultant = consultantRepository.findById(requestConsultantByIdDto.getId()).orElse(null);

        if (consultant == null) throw new ConsultantNotFoundException("Consultant not found with the id of: " + requestConsultantByIdDto.getId());


        return new ResponseConsultantDto(consultant);
    }

    @Override
    public ResponseConsultantAllDto findAll(RequestConsultantDto requestConsultantDto) {


        if(requestConsultantDto.getId() != null){
            Consultant[] consultant = {consultantRepository.findById(requestConsultantDto.getId()).orElse(null)};
            return new ResponseConsultantAllDto(consultant);

        }

        Consultant consultant = Consultant.builder()
                .name(requestConsultantDto.getName())
                .specializations(requestConsultantDto.getSpecializations())
                .build();

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Consultant> example = Example.of(consultant, matcher);
        List<Consultant> consultants = consultantRepository.findAll(example);
        Consultant[] toReturn = new Consultant[consultants.size()];
        toReturn = consultants.toArray(toReturn);

        return new ResponseConsultantAllDto(toReturn);
    }

    @Override
    public ResponseConsultantDto delete(RequestConsultantByIdDto requestConsultantByIdDto) throws ConsultantNotFoundException {

        Consultant consultant = consultantRepository.findById(requestConsultantByIdDto.getId()).orElse(null);

        if(consultant == null) {
            throw new ConsultantNotFoundException("Consultant not found with the id of: " + requestConsultantByIdDto.getId());
        } else {
            consultantRepository.delete(consultant);
        }


        return null;
    }
}
