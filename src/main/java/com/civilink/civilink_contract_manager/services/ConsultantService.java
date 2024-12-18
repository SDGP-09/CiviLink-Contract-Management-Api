package com.civilink.civilink_contract_manager.services;


import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseConsultantAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseConsultantDto;
import com.civilink.civilink_contract_manager.exception.ConsultantNotFoundException;

public interface ConsultantService {
    public void createConsultant(RequestConsultantDto requestConsultantDto);
    public void addProjectToConsultant(RequestConsultantProjectDto requestConsultantProjectDto);

    public ResponseConsultantDto update(RequestConsultantUpdateDto requestConsultantUpdateDto) throws ConsultantNotFoundException;

    public ResponseConsultantDto findById(RequestConsultantByIdDto requestConsultantByIdDto) throws ConsultantNotFoundException;

    public ResponseConsultantAllDto findAll(RequestConsultantDto requestConsultantDto);

    public ResponseConsultantDto delete(RequestConsultantByIdDto requestConsultantByIdDto) throws ConsultantNotFoundException;
}
