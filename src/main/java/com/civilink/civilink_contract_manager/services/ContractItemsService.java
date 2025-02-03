package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemsByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemsDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemsUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractItemsAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractItemsDto;
import com.civilink.civilink_contract_manager.exception.ContractItemsNotFoundException;

public interface ContractItemsService {
    public void createContractItems(RequestContractItemsDto contractItemDto);

    ResponseContractItemsDto updateContractItems(RequestContractItemsUpdateDto request) throws ContractItemsNotFoundException;

    ResponseContractItemsDto findById(RequestContractItemsByIdDto request) throws ContractItemsNotFoundException;

    ResponseContractItemsAllDto findAll(RequestContractItemsDto requestDto);

    void deleteContractItems(RequestContractItemsByIdDto request) throws ContractItemsNotFoundException;
}
