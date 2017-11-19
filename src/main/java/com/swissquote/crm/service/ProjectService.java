package com.swissquote.crm.service;

import com.swissquote.crm.model.Projects;

/**
 * Service for getting information by projects
 */
public interface ProjectService {

    /**
     * Gets mercurial information by all projects from working directory
     *
     * @return projects {@link Projects}
     */
    Projects getProjects();
}
