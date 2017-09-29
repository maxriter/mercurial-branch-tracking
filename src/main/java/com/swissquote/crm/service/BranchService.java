package com.swissquote.crm.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.swissquote.crm.model.Commit;
import com.swissquote.crm.model.Projects;

public interface BranchService {

    List<String> getOpenedBranches(String projectName) throws IOException, InterruptedException;

    Map<String, List<Commit>> getCommitsOfOpenedBranches(String projectName) throws IOException, InterruptedException;

    Projects getProjects();

}
