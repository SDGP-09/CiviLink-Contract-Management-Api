package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.ContractItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Builder


public class ResponseContractItemsDto {
    private ContractItems contractItems;

    public ContractItems getContractItems() {
        return contractItems;
    }

    public void setContractItems(ContractItems contractItems) {
        this.contractItems = contractItems;
    }
}
