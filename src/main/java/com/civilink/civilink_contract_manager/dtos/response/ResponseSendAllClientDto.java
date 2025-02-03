package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseSendAllClientDto {
    private Client[] allClients;
}
