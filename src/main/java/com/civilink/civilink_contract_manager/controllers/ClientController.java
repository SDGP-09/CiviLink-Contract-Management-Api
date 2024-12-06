package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestClientDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientProjectDto;
import com.civilink.civilink_contract_manager.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
