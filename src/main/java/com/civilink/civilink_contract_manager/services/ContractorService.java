package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorDto;
import com.civilink.civilink_contract_manager.entities.Contractor;

public interface ContractorService {
    public void createContractor(RequestContractorDto requestContractorDto);
}
