package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestClientByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientUpdateDTO;
import com.civilink.civilink_contract_manager.dtos.response.ResponseClientDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseSendAllClientDto;
import com.civilink.civilink_contract_manager.exception.ClientNotFoundException;

public interface ClientService {
    public void createClient(RequestClientDto requestClientDto);
    public void addProjectToClient(RequestClientProjectDto requestClientProjectDto);

    public ResponseClientDto updateClient(RequestClientUpdateDTO requestClientUpdateDTO) throws ClientNotFoundException;

    public ResponseClientDto findClientById(RequestClientByIdDto requestClientByIdDto) throws ClientNotFoundException;

    public ResponseSendAllClientDto findAllClient(RequestClientDto requestClientDto);

    public void deleteClient(RequestClientByIdDto requestClientByIdDto) throws ClientNotFoundException;
}
