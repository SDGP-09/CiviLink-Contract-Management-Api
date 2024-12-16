package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorDto;
import com.civilink.civilink_contract_manager.entities.Contractor;
import com.civilink.civilink_contract_manager.exception.ContractorNotFoundException;

public interface ContractorService {
    public void createContractor(RequestContractorDto requestContractorDto);

    public ResponseContractorDto updateContractor(RequestContractorUpdateDto requestContractorUpdateDto) throws ContractorNotFoundException;

    public ResponseContractorDto findById(RequestContractorByIdDto requestContractorByIdDto) throws ContractorNotFoundException;

    public ResponseContractorAllDto findAll(RequestContractorDto requestContractorDto);

    public void deleteContractor(RequestContractorByIdDto requestContractorByIdDto) throws ContractorNotFoundException;
}
