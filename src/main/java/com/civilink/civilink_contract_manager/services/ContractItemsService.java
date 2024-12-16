package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemDto;
import com.civilink.civilink_contract_manager.entities.ContractItems;

public interface ContractItemsService {
    public void createContractItems(RequestContractItemDto contractItemDto);

}
