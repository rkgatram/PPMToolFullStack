package com.rkgatram.ppmtool.web;

import com.rkgatram.ppmtool.domain.Project;
import com.rkgatram.ppmtool.services.MapValidationErrorService;
import com.rkgatram.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by ravikumar.g
 * Date 2019-11-09
 */
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

}
