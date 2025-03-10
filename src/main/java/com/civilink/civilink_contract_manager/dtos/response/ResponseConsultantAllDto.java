package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Consultant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Builder

public class ResponseConsultantAllDto {
    private Consultant[] consultants;

    public Consultant[] getConsultants() {
        return consultants;
    }

    public void setConsultants(Consultant[] consultants) {
        this.consultants = consultants;
    }
}
