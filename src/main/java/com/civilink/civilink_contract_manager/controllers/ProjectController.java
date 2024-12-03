package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectDto;
import com.civilink.civilink_contract_manager.services.ProjectService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createProject(@RequestBody RequestProjectDto requestProjectDto) {
        System.out.println(requestProjectDto);
        projectService.createProject(requestProjectDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Project Created",requestProjectDto.getProjectName()),
                HttpStatus.CREATED);
    }
}
