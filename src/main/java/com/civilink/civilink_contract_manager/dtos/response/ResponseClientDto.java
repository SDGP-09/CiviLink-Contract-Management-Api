package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Builder

public class ResponseClientDto {

    private Client updatedClient;

    public Client getUpdatedClient() {
        return updatedClient;
    }

    public void setUpdatedClient(Client updatedClient) {
        this.updatedClient = updatedClient;
    }
}
