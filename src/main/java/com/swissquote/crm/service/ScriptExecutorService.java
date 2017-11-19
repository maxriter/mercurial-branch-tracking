package com.swissquote.crm.service;

import java.util.List;
import java.util.Map;

/**
 * Service for retrieving mercurial info by executing bash scripts
 */
public interface ScriptExecutorService {

    /**
     * Gets list of opened branches by project name
     *
     * @param projectName name of the project
     * @return list of opened branches
     */
    List<String> getOpenedBranches(String projectName);

    /**
     * Gets commits of opened branches by project name
     *
     * @param projectName name of the project
     * @return commits as string by branch name
     */
    Map<String, String> getCommitsOfOpenedBranches(String projectName);

    /**
     * Gets list of all projects from working directory
     *
     * @return list of project names
     */
    List<String> getProjectNames();

}
