package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractDto;
import com.civilink.civilink_contract_manager.entities.Contract;
import com.civilink.civilink_contract_manager.entities.ContractItems;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.exception.ContractNotFoundException;
import com.civilink.civilink_contract_manager.repositories.ContractItemsRepository;
import com.civilink.civilink_contract_manager.repositories.ContractRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ProjectRepository projectRepository;
    private final ContractItemsRepository contractItemsRepository;

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

    @Override
    public ResponseContractDto updateContract(RequestContractUpdateDto requestContractUpdateDto) throws ContractNotFoundException {
        Contract contract = contractRepository.findById(requestContractUpdateDto.getId()).orElse(null);

        if (contract == null) {
            throw new ContractNotFoundException("Contract not found with the id of: " + requestContractUpdateDto.getId());
        }


        if (requestContractUpdateDto.getProject() != null) {

            Project updatedProject = projectRepository.save(requestContractUpdateDto.getProject());
            contract.setProject(updatedProject);
        }


        if (requestContractUpdateDto.getContractItems() != null) {

            List<ContractItems> updatedItems = requestContractUpdateDto.getContractItems()
                    .stream()
                    .map(contractItem -> contractItemsRepository.save(contractItem))
                    .toList();
            contract.setContracts(updatedItems);
        }


        if (requestContractUpdateDto.getDescription() != null) {
            contract.setDescription(requestContractUpdateDto.getDescription());
        }

        if (requestContractUpdateDto.getContractDate() != null) {
            contract.setContractDate(requestContractUpdateDto.getContractDate());
        }


        Contract updatedContract = contractRepository.save(contract);


        return new ResponseContractDto(updatedContract);
    }

    @Override
    public ResponseContractDto findById(RequestContractByIdDto requestContractByIdDto) throws ContractNotFoundException {
        Contract contract = contractRepository.findById(requestContractByIdDto.getId()).orElse(null);
        if (contract == null) {
            throw new ContractNotFoundException("Contract not found with the id of: " + requestContractByIdDto.getId());
        }

        return new ResponseContractDto(contract);
    }

    @Override
    public ResponseContractAllDto findAll(RequestContractDto requestContractDto) {

        if (requestContractDto.getId() != null) {
            Contract contract = contractRepository.findById(requestContractDto.getId()).orElse(null);
            Contract[] contracts = { contract };
            return new ResponseContractAllDto(contracts);
        } else {

            Contract exampleContract = Contract.builder()
                    .description(requestContractDto.getDescription())
                    .contractDate(requestContractDto.getContractDate())
                    .build();

            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
            Example<Contract> example = Example.of(exampleContract, matcher);

            List<Contract> contractList = contractRepository.findAll(example);
            Contract[] toReturn = new Contract[contractList.size()];
            toReturn = contractList.toArray(toReturn);

            return new ResponseContractAllDto(toReturn);
        }
    }

    @Override
    public void deleteContract(RequestContractByIdDto requestContractByIdDto) throws ContractNotFoundException {
        Contract contract = contractRepository.findById(requestContractByIdDto.getId()).orElse(null);
        if (contract == null) {
            throw new ContractNotFoundException("Contract not found with the id of: " + requestContractByIdDto.getId());
        } else {
            contractRepository.delete(contract);
        }
    }
}
