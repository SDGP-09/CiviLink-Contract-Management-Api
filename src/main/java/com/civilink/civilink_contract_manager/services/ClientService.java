package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestClientDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestClientUpdateDTO;

public interface ClientService {
    public void createClient(RequestClientDto requestClientDto);
    public void addProjectToClient(RequestClientProjectDto requestClientProjectDto);

    public void updateClient(RequestClientUpdateDTO requestClientUpdateDTO);

}
