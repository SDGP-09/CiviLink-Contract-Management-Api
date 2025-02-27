package com.civilink.civilink_contract_manager.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestContractDto {
    private long id;
    private String projectId;
    private String description;
    private String contractDate;
}
