package com.swissquote.crm;

import com.swissquote.crm.model.Branch;
import com.swissquote.crm.model.Commit;
import com.swissquote.crm.model.Project;
import com.swissquote.crm.model.Projects;
import com.swissquote.crm.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class MainController {

    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/opened-branches/{projectName}", method = RequestMethod.GET)
    public List<String> getOpenedBranches(@PathVariable("projectName") String projectName) throws IOException, InterruptedException {
        return branchService.getOpenedBranches(projectName);
    }

    @RequestMapping(value = "/commits-in-opened-branches/{projectName}", method = RequestMethod.GET)
    public Map<String, List<Commit>> getCommitsOfOpenedBranches(@PathVariable("projectName") String projectName)
            throws IOException, InterruptedException {
        return branchService.getCommitsOfOpenedBranches(projectName);
    }

    @RequestMapping(value = "/init-state", method = RequestMethod.GET)
    public Projects getInitState() {
        return getState();
    }

    // mocked for a while
    // TODO: add call to service to retrieve  data
    private Projects getState() {
        Projects projects = new Projects();
        Project project = new Project();
        Branch AOCMW1 = new Branch();
        AOCMW1.setComment("This is AOCMW1 branch from [test-plugin-name]");
        AOCMW1.setRelatedProjects(Arrays.asList("sqc-test2-plugin", "sqc-test3-plugin"));
        AOCMW1.setName("AOCMW1");

        Branch AOCMW2 = new Branch();
        AOCMW2.setComment("This is AOCMW2 branch from [test-plugin-name]");
        AOCMW2.setName("AOCMW2");

        project.setName("test-plugin-name");
        project.setOpenedBranches(Arrays.asList(AOCMW1, AOCMW2));

        projects.setProjects(Collections.singletonList(project));
        return projects;
    }
}
