package com.civilink.civilink_contract_manager.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestContractItemsDto {
    private String id;
    private String url;
    private String description;
    private String contractId;
}
