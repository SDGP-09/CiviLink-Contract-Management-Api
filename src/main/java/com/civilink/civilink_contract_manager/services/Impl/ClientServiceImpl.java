package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestClientDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientUpdateDTO;
import com.civilink.civilink_contract_manager.entities.Client;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.ClientRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ProjectRepository projectRepository;

    @Override
    public void createClient(RequestClientDto requestClientDto) {

        Client client = Client.builder()
                .id(requestClientDto.getId())
                .name(requestClientDto.getName())
                .contact(requestClientDto.getContact())
                .build();

        clientRepository.save(client);

    }

    @Override
    public void addProjectToClient(RequestClientProjectDto requestClientProjectDto) {
        Project project = projectRepository.findById(requestClientProjectDto.getProjectId()).get();

        Client client = clientRepository.findById(requestClientProjectDto.getClientId()).get();

        client.getProjectList().add(project);

        clientRepository.save(client);
    }

    @Override
    public void updateClient(RequestClientUpdateDTO requestClientUpdateDTO) {
        
    }


}
