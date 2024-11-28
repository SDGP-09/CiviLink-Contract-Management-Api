package com.civilink.civilink_contract_manager.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestProjectDto {

    private String projectId;
    private int projectNumber;
    private String projectName;
    private String projectDescription;
    private String projectStartDate;
    private String projectEndDate;
    private String projectStatus;
    private String projectCategory;
}
