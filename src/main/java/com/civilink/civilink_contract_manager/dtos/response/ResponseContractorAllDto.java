package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Contractor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ResponseContractorAllDto {
    private Contractor[] contractors;
}
