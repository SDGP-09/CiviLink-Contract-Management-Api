package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestClientByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientUpdateDTO;
import com.civilink.civilink_contract_manager.dtos.response.ResponseClientDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseSendAllClientDto;
import com.civilink.civilink_contract_manager.exception.ClientNotFoundException;
import com.civilink.civilink_contract_manager.services.ClientService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/post")
    public void createClient(@RequestBody RequestClientDto clientDto) {
        clientService.createClient(clientDto);
    }

    @PostMapping("/add-project")
    public void addProjectToClient(@RequestBody RequestClientProjectDto projectDto) {
        clientService.addProjectToClient(projectDto);
    }

    @PostMapping("/update-client")
    public ResponseEntity<StandardResponse> updateClient(
            @RequestBody RequestClientUpdateDTO requestClientUpdateDTO){
        ResponseClientDto responseClientDto = null;
        try {
            responseClientDto = clientService.updateClient(requestClientUpdateDTO);
        } catch (ClientNotFoundException e){
            System.out.println(e);
        }

        return new ResponseEntity<>(
                new StandardResponse(201,"Client details updated", responseClientDto),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/find-client-by-id")
    public ResponseEntity<StandardResponse> findClientById(
            @RequestBody RequestClientByIdDto requestClientByIdDto
            ){

        ResponseClientDto responseClientDto = null;

        try {
            responseClientDto = clientService.findClientById(requestClientByIdDto);
        } catch (ClientNotFoundException e){
            System.out.println(e);
        }


        return new ResponseEntity<>(
                new StandardResponse(201,"Client retrieved", responseClientDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/find-all-client")
    public ResponseEntity<StandardResponse> findAllClients(
            @RequestBody RequestClientDto requestClientDto
    ){
        ResponseSendAllClientDto responseSendAllClientDto = clientService.findAllClient(requestClientDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Clients retrieved", responseSendAllClientDto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete")
    public void deleteClient(
            @RequestBody RequestClientByIdDto requestClientByIdDto
    ){
        try{
            clientService.deleteClient(requestClientByIdDto);
        } catch (ClientNotFoundException e){
            System.out.println(e);
        }


    }

}
