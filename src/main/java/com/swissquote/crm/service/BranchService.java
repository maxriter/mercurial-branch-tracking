package com.swissquote.crm.service;

import com.swissquote.crm.model.Branch;

import java.util.List;

/**
 * Service for getting information of the branches
 */
public interface BranchService {

    /**
     * Gets list of opened branches by project
     *
     * @param projectName name of the project
     * @return list of opened branch names
     */
    List<String> getListOfOpenedBranches(String projectName);

    /**
     * Gets branches {@link Branch} by project
     *
     * @param projectName name of the project
     * @return list of branches {@link Branch}
     */
    List<Branch> getInfoByOpenedBranches(String projectName);

}
