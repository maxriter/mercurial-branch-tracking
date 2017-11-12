package com.swissquote.crm.service;

import com.swissquote.crm.model.Branch;
import com.swissquote.crm.model.Projects;

import java.util.List;

public interface BranchService {

    List<String> getListOfOpenedBranches(String projectName);

    List<Branch> getBranches(String projectName);

    Projects getProjects();

}
