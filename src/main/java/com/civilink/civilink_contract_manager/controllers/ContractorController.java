package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorDto;
import com.civilink.civilink_contract_manager.exception.ContractorNotFoundException;
import com.civilink.civilink_contract_manager.services.ContractorService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contractor")
@RequiredArgsConstructor
public class ContractorController {

    private final ContractorService contractorService;

    @PostMapping("/create")
    public void createContractor(@RequestBody RequestContractorDto requestContractorDto) {
        contractorService.createContractor(requestContractorDto);
    }


    @PatchMapping("/update")
    public ResponseEntity<StandardResponse> updatedContractor(
            @RequestBody RequestContractorUpdateDto contractorUpdateDto
    ){

        ResponseContractorDto responseContractorDto = null;

        try {
            responseContractorDto = contractorService.updateContractor(contractorUpdateDto);
        } catch (ContractorNotFoundException e){
            System.out.println(e);
        }


        return new ResponseEntity<>(
                new StandardResponse(201,"Contractor information updated", responseContractorDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/find-by-id")
    public ResponseEntity<StandardResponse> findById(
            @RequestBody RequestContractorByIdDto requestContractorByIdDto
    ){
        ResponseContractorDto responseContractorDto = null;
        try{
            responseContractorDto = contractorService.findById(requestContractorByIdDto);
        } catch (ContractorNotFoundException e){
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201,"Client retrieved", responseContractorDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/find-all")
    public ResponseEntity<StandardResponse> findAllById(
            @RequestBody RequestContractorDto requestContractorDto
    ){
        ResponseContractorAllDto responseContractorAllDto = contractorService.findAll(requestContractorDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Client retrieved", responseContractorAllDto),
                HttpStatus.CREATED
        );
    }


    public void deleteContractor(
            @RequestBody RequestContractorByIdDto requestContractorByIdDto
    ){

        try {
            contractorService.deleteContractor(requestContractorByIdDto);
        } catch (ContractorNotFoundException e){
            System.out.println(e);
        }
        

    }


}
