package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestClientByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientUpdateDTO;
import com.civilink.civilink_contract_manager.dtos.response.ResponseClientDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseSendAllClientDto;
import com.civilink.civilink_contract_manager.entities.Client;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.exception.ClientNotFoundException;
import com.civilink.civilink_contract_manager.repositories.ClientRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseClientDto updateClient(RequestClientUpdateDTO requestClientUpdateDTO) throws ClientNotFoundException {
        Client client = clientRepository.findById(requestClientUpdateDTO.getId()).orElse(null);

        if (client == null){
            throw new ClientNotFoundException("Client not found with the id of: " + requestClientUpdateDTO.getId());
        }

        if (requestClientUpdateDTO.getName() != null) client.setName(requestClientUpdateDTO.getName());
        if (requestClientUpdateDTO.getContact() != null) client.setContact(requestClientUpdateDTO.getContact());
        if (requestClientUpdateDTO.getProjectList() != null) {
            List<Project> updatedProjects = requestClientUpdateDTO.getProjectList()
                    .stream()
                    .map(project -> projectRepository.save(project))
                    .toList();
            client.setProjectList(updatedProjects);
        }

        Client updatedClient = clientRepository.save(client);
        return new ResponseClientDto(updatedClient);
    }

    @Override
    public ResponseClientDto findClientById(RequestClientByIdDto requestClientByIdDto) throws ClientNotFoundException {
        Client client = clientRepository.findById(requestClientByIdDto.getId()).orElse(null);
        if (client == null) throw new ClientNotFoundException("Client not found with the id of: " + requestClientByIdDto.getId());

        return new ResponseClientDto(client);
    }

    @Override
    public ResponseSendAllClientDto findAllClient(RequestClientDto requestClientDto) {

        if (requestClientDto.getId() != null) {

            Client client = clientRepository.findById(requestClientDto.getId()).orElse(null);
            Client[] clients = {client};


            return new ResponseSendAllClientDto(clients);
        }else {

            Client client = Client.builder()
                    .name(requestClientDto.getName())
                    .contact(requestClientDto.getContact())
                    .build();

            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();

            Example<Client> example = Example.of(client, matcher);
            List<Client> clients = clientRepository.findAll(example);
            Client[] toReturn = new Client[clients.size()];
            toReturn = clients.toArray(toReturn);


            return new ResponseSendAllClientDto(toReturn);
        }
    }

    @Override
    public void deleteClient(RequestClientByIdDto requestClientByIdDto) throws ClientNotFoundException {
        Client client = clientRepository.findById(requestClientByIdDto.getId()).orElse(null);

        if (client == null){
            throw new ClientNotFoundException("Client not found with the id of: " + requestClientByIdDto.getId());
        } else {
            clientRepository.delete(client);
        }
    }


}
