package com.civilink.civilink_contract_manager.services;


import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantProjectDto;

public interface ConsultantService {
    public void createConsultant(RequestConsultantDto requestConsultantDto);
    public void addProjectToConsultant(RequestConsultantProjectDto requestConsultantProjectDto);
}
