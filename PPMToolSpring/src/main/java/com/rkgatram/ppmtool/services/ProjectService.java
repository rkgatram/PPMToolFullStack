package com.rkgatram.ppmtool.services;

import com.rkgatram.ppmtool.domain.Project;
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

        // Logic

        return projectRepository.save(project);
    }
}
