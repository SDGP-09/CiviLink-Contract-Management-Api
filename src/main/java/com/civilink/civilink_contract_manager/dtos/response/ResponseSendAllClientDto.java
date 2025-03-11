package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor


public class ResponseSendAllClientDto {
    private Client[] allClients;

    public Client[] getAllClients() {
        return allClients;
    }

    public void setAllClients(Client[] allClients) {
        this.allClients = allClients;
    }
}
