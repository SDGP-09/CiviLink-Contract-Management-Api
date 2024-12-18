package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseConsultantAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseConsultantDto;
import com.civilink.civilink_contract_manager.entities.Consultant;
import com.civilink.civilink_contract_manager.exception.ConsultantNotFoundException;
import com.civilink.civilink_contract_manager.services.ConsultantService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import jakarta.el.StandardELContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.jar.JarOutputStream;

@RestController
@RequestMapping("api/v1/consultant")
@RequiredArgsConstructor
public class ConsultantController {

    private final ConsultantService consultantService;

    @PostMapping("/create")
    public void createConsultant(@RequestBody RequestConsultantDto consultantDto) {
        consultantService.createConsultant(consultantDto);
    }

    @RequestMapping("/add-project")
    public void addProjectToConsultant(@RequestBody RequestConsultantProjectDto consultantProjectDto) {
        consultantService.addProjectToConsultant(consultantProjectDto);
    }

    @PostMapping("/update")
    public ResponseEntity<StandardResponse> updated(
            @RequestBody RequestConsultantUpdateDto requestConsultantUpdateDto
            ){
        ResponseConsultantDto responseConsultantDto = null;

        try {
            responseConsultantDto = consultantService.update(requestConsultantUpdateDto);
        } catch (ConsultantNotFoundException e){
            System.out.println(e);
        }


        return new ResponseEntity<>(
                new StandardResponse(201,"Consultant updated", responseConsultantDto),
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<StandardResponse> findById(
            @RequestBody RequestConsultantByIdDto requestConsultantByIdDto
            ){
        ResponseConsultantDto responseConsultantDto = null;
        try {
            responseConsultantDto = consultantService.findById(requestConsultantByIdDto);
        } catch (ConsultantNotFoundException e){
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201,"Consultant updated", responseConsultantDto),
                HttpStatus.CREATED
        );
    }


    @PostMapping("/find-all-consultants")
    public ResponseEntity<StandardResponse> findAll(
            @RequestBody RequestConsultantDto requestConsultantDto
    ){

        ResponseConsultantAllDto responseConsultantAllDto = consultantService.findAll(requestConsultantDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Consultant updated", responseConsultantAllDto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete-consultant")
    public void deleteConsultant(
            @RequestBody RequestConsultantByIdDto requestConsultantByIdDto
    ){
        try{
            consultantService.delete(requestConsultantByIdDto);
        }catch (ConsultantNotFoundException e){
            System.out.println(e);
        }
    }
}
