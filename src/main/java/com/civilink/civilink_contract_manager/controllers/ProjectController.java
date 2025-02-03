package com.civilink.civilink_contract_manager.controllers;

import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectFindByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestProjectUpdateDto;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.services.ProjectService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/find-by-id")
    public ResponseEntity<StandardResponse> projectFindById(@RequestBody RequestProjectFindByIdDto requestProjectFindByIdDto) {
        Project project = projectService.findById(requestProjectFindByIdDto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Project Found",project),
                HttpStatus.OK);
    }


    @PutMapping("/update-project")
    public ResponseEntity<StandardResponse> updateProject(@RequestBody RequestProjectUpdateDto requestProjectUpdateDto) {
        projectService.updateProject(requestProjectUpdateDto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Project Updated",requestProjectUpdateDto.getProjectNumber()),
                HttpStatus.OK);
    }
}
