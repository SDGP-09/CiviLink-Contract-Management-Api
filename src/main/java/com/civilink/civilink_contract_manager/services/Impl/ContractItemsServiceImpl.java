package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemDto;
import com.civilink.civilink_contract_manager.entities.Contract;
import com.civilink.civilink_contract_manager.entities.ContractItems;
import com.civilink.civilink_contract_manager.repositories.ContractItemsRepository;
import com.civilink.civilink_contract_manager.repositories.ContractRepository;
import com.civilink.civilink_contract_manager.services.ContractItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractItemsServiceImpl implements ContractItemsService {

    private final ContractItemsRepository contractItemsRepository;
    private final ContractRepository contractRepository;

    @Override
    public void createContractItems(RequestContractItemDto contractItemDto) {

        Contract contract = contractRepository.findById(contractItemDto.getContractId()).get();

        ContractItems contractItems = ContractItems.builder()
                .id(contractItemDto.getId())
                .description(contractItemDto.getDescription())
                .url(contractItemDto.getUrl())
                .contract(contract)
                .build();

        contractItemsRepository.save(contractItems);

        contract.getContracts().add(contractItems);
        contractRepository.save(contract);
    }
}
