package com.rkgatram.ppmtool.web;

import com.rkgatram.ppmtool.domain.Project;
import com.rkgatram.ppmtool.services.MapValidationErrorService;
import com.rkgatram.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ravikumar.g
 * Date 2019-11-09
 */
@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService errorService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        final ResponseEntity<?> errorMap = errorService.mapValidationService(result);

        if(errorMap != null) {
            return errorMap;
        }

        Project newProject = projectService.saveOrUpdateProject(project);

        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){

        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping
    public Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable String projectId) {

         projectService.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<>("Project with Id : '" + projectId + "' was deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, BindingResult bindingResult) {

        ResponseEntity<?> errorMap = new MapValidationErrorService().mapValidationService(bindingResult);

        if(errorMap != null) {
            return errorMap;
        }

        Project updatedProject = projectService.saveOrUpdateProject(project);

        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

}
