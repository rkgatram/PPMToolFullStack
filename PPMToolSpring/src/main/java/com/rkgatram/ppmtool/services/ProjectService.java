package com.rkgatram.ppmtool.services;

import com.rkgatram.ppmtool.domain.Project;
import com.rkgatram.ppmtool.exceptions.ProjectIdException;
import com.rkgatram.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by ravikumar.g
 * Date 2019-11-09
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        try {

            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        }catch (Exception ex) {
            throw new ProjectIdException("Project Id '" + project.getProjectIdentifier() + "' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null) {
            throw new ProjectIdException("Project Id '" + projectId + "' does not exists");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null) {
            throw new ProjectIdException("Project Id '" + projectId + "' does not exists");
        }

        projectRepository.delete(project);
    }


}
