package com.swissquote.crm.service.impl;

import com.swissquote.crm.model.Branch;
import com.swissquote.crm.model.Project;
import com.swissquote.crm.model.Projects;
import com.swissquote.crm.service.BranchService;
import com.swissquote.crm.service.ProjectService;
import com.swissquote.crm.service.ScriptExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ScriptExecutorService scriptExecutorService;

    @Autowired
    private BranchService branchService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Projects getProjects() {
        List<Project> projects = scriptExecutorService.getProjectNames().stream()
                .map(projectName -> new Project(projectName, branchService.getInfoByOpenedBranches(projectName)))
                .collect(Collectors.toList());
        setRelatedProjectsForBranches(projects);
        return new Projects(projects);
    }

    private void setRelatedProjectsForBranches(List<Project> projects) {
        Map<String, List<String>> relatedProjectsByBranches = getRelatedProjects(projects);
        projects.forEach(project ->
                project.getOpenedBranches().forEach(branch ->
                        branch.setRelatedProjects(relatedProjectsByBranches.get(branch.getName()))));
    }

    private Map<String, List<String>> getRelatedProjects(List<Project> projects) {
        Map<String, List<String>> relatedProjectsByBranches = new HashMap<>();
        projects.forEach(project -> {
            List<String> branches = project.getOpenedBranches().stream().map(Branch::getName).collect(Collectors.toList());
            branches.forEach(branch -> {
                if (relatedProjectsByBranches.containsKey(branch)) {
                    relatedProjectsByBranches.get(branch).add(project.getName());
                } else {
                    relatedProjectsByBranches.put(branch, new ArrayList<>(Collections.singletonList(project.getName())));
                }
            });
        });
        return relatedProjectsByBranches;
    }
}
