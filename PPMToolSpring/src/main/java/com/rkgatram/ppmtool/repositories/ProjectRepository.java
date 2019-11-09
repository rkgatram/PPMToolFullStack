package com.rkgatram.ppmtool.repositories;

import com.rkgatram.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ravikumar.g
 * Date 2019-11-09
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
