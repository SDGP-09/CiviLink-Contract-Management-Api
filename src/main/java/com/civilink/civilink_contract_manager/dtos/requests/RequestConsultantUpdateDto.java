package com.civilink.civilink_contract_manager.dtos.requests;

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

public class RequestConsultantUpdateDto {
    private String id;
    private String name;
    private String specializations;
    private List<Project> projectsList;
}
