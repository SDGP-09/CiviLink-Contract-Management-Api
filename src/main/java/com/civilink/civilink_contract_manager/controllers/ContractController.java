package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.*;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractItemsAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractItemsDto;
import com.civilink.civilink_contract_manager.exception.ContractItemsNotFoundException;
import com.civilink.civilink_contract_manager.exception.ContractNotFoundException;
import com.civilink.civilink_contract_manager.services.ContractItemsService;
import com.civilink.civilink_contract_manager.services.ContractService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<StandardResponse> createContractItem(@RequestBody RequestContractItemsDto contractItemDto) {
        contractItemsService.createContractItems(contractItemDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Contract item Created",contractItemDto.getId()),
                HttpStatus.CREATED
            );
    }

    @PatchMapping("/update")
    public ResponseEntity<StandardResponse> updateContract(
            @RequestBody RequestContractUpdateDto requestContractUpdateDto) {

        ResponseContractDto responseContractDto = null;
        try {
            responseContractDto = contractService.updateContract(requestContractUpdateDto);
        } catch (ContractNotFoundException e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201, "Contract details updated", responseContractDto),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/find-contract-by-id")
    public ResponseEntity<StandardResponse> findContractById(
            @RequestBody RequestContractByIdDto requestContractByIdDto) {

        ResponseContractDto responseContractDto = null;
        try {
            responseContractDto = contractService.findById(requestContractByIdDto);
        } catch (ContractNotFoundException e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201, "Contract retrieved", responseContractDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/find-all-contract")
    public ResponseEntity<StandardResponse> findAllContracts(
            @RequestBody RequestContractDto requestContractDto) {

        ResponseContractAllDto responseContractAllDto = contractService.findAll(requestContractDto);

        return new ResponseEntity<>(
                new StandardResponse(201, "Contracts retrieved", responseContractAllDto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete-contract")
    public void deleteContract(
            @RequestBody RequestContractByIdDto requestContractByIdDto) {
        try {
            contractService.deleteContract(requestContractByIdDto);
        } catch (ContractNotFoundException e) {
            System.out.println(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<StandardResponse> updateContractItems(
            @RequestBody RequestContractItemsUpdateDto requestContractItemsUpdateDto) {
        ResponseContractItemsDto response = null;
        try {
            response = contractItemsService.updateContractItems(requestContractItemsUpdateDto);
        } catch (ContractItemsNotFoundException e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201, "ContractItems details updated", response),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/find-by-id")
    public ResponseEntity<StandardResponse> findContractItemsById(
            @RequestBody RequestContractItemsByIdDto requestContractItemsByIdDto) {

        ResponseContractItemsDto response = null;
        try {
            response = contractItemsService.findById(requestContractItemsByIdDto);
        } catch (ContractItemsNotFoundException e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201, "ContractItems retrieved", response),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/find-all")
    public ResponseEntity<StandardResponse> findAllContractItems(
            @RequestBody RequestContractItemsDto requestContractItemsDto) {

        ResponseContractItemsAllDto responseAll = contractItemsService.findAll(requestContractItemsDto);

        return new ResponseEntity<>(
                new StandardResponse(201, "ContractItems retrieved", responseAll),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete-contract-item")
    public void deleteContractItems(
            @RequestBody RequestContractItemsByIdDto requestContractItemsByIdDto) {
        try {
            contractItemsService.deleteContractItems(requestContractItemsByIdDto);
        } catch (ContractItemsNotFoundException e) {
            System.out.println(e);
        }
    }

}
