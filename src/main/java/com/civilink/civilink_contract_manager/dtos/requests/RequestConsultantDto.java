package com.civilink.civilink_contract_manager.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class RequestConsultantDto {
    private String id;
    private String name;
    private String Specializations;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecializations() {
        return Specializations;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecializations(String specializations) {
        Specializations = specializations;
    }
}
