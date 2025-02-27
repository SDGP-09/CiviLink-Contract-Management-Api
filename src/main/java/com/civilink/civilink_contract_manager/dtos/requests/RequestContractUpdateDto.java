package com.civilink.civilink_contract_manager.dtos.requests;

import com.civilink.civilink_contract_manager.entities.ContractItems;
import com.civilink.civilink_contract_manager.entities.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class RequestContractUpdateDto {

    private String id;
    private Project project;
    private List<ContractItems> contractItems;
    private String description;
    private String contractDate;
}
