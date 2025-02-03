package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractDto;

public interface ContractService {
    public void createContract(RequestContractDto contract);
}
