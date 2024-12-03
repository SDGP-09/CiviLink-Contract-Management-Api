package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractDto;
import com.civilink.civilink_contract_manager.entities.Contract;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.ContractRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ProjectRepository projectRepository;

    @Override
    public void createContract(RequestContractDto contractDto) {

        Project project = projectRepository.findById(contractDto.getProjectId()).get();

        Contract contract = Contract.builder()
                .id(contractDto.getId())
                .description(contractDto.getDescription())
                .contractDate(contractDto.getContractDate())
                .project(project)
                .contracts(null)
                .build();

        contractRepository.save(contract);

        project.setContract(contract);

        projectRepository.save(project);

    }
}
