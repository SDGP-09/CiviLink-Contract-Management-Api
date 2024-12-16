package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorDto;
import com.civilink.civilink_contract_manager.services.ContractItemsService;
import com.civilink.civilink_contract_manager.services.ContractService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    private final ContractItemsService contractItemsService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createContract(@RequestBody RequestContractDto contractDto) {
        contractService.createContract(contractDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Contract Created",contractDto.getId())
                , HttpStatus.CREATED);
    }

    @PostMapping("/create-contract-item")
    public ResponseEntity<StandardResponse> createContractItem(@RequestBody RequestContractItemDto contractItemDto) {
        contractItemsService.createContractItems(contractItemDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Contract item Created",contractItemDto.getId()),
                HttpStatus.CREATED
            );
    }
}
