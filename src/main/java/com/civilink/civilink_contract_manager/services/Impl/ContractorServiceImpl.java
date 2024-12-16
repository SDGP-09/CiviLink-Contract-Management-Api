package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorDto;
import com.civilink.civilink_contract_manager.entities.Contractor;
import com.civilink.civilink_contract_manager.repositories.ContractorRepository;
import com.civilink.civilink_contract_manager.services.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractorServiceImpl implements ContractorService {

    private final ContractorRepository contractorRepository;

    @Override
    public void createContractor(RequestContractorDto requestContractorDto) {
        Contractor contractor = Contractor.builder()
                .id(requestContractorDto.getId())
                .name(requestContractorDto.getName())
                .contact(requestContractorDto.getContact())
                .build();

        contractorRepository.save(contractor);
    }
}
