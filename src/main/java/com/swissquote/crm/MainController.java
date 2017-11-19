package com.swissquote.crm;

import com.swissquote.crm.model.Branch;
import com.swissquote.crm.model.Projects;
import com.swissquote.crm.service.BranchService;
import com.swissquote.crm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class MainController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public Projects getProjects() {
        return projectService.getProjects();
    }

    @RequestMapping(value = "/openedBranches/{projectName}", method = RequestMethod.GET)
    public List<String> getListOfOpenedBranches(@PathVariable("projectName") String projectName) {
        return branchService.getListOfOpenedBranches(projectName);
    }

    @RequestMapping(value = "/branches/{projectName}", method = RequestMethod.GET)
    public List<Branch> getBranches(@PathVariable("projectName") String projectName) {
        return branchService.getInfoByOpenedBranches(projectName);
    }

}
