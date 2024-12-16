package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestConsultantProjectDto;
import com.civilink.civilink_contract_manager.services.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/consultant")
@RequiredArgsConstructor
public class ConsultantController {

    private final ConsultantService consultantService;

    @PostMapping("/create")
    public void createConsultant(@RequestBody RequestConsultantDto consultantDto) {
        consultantService.createConsultant(consultantDto);
    }

    @RequestMapping("/add-project")
    public void addProjectToConsultant(@RequestBody RequestConsultantProjectDto consultantProjectDto) {
        consultantService.addProjectToConsultant(consultantProjectDto);
    }
}
