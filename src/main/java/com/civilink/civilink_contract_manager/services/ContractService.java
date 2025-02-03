package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractDto;
import com.civilink.civilink_contract_manager.exception.ContractNotFoundException;

public interface ContractService {
    public void createContract(RequestContractDto contract);

    public ResponseContractDto updateContract(RequestContractUpdateDto requestContractUpdateDto) throws ContractNotFoundException;

    public ResponseContractDto findById(RequestContractByIdDto requestContractByIdDto) throws ContractNotFoundException;

    public ResponseContractAllDto findAll(RequestContractDto requestContractDto);

    public void deleteContract(RequestContractByIdDto requestContractByIdDto) throws ContractNotFoundException;
}
