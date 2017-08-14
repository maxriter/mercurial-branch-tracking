package com.swissquote.crm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swissquote.crm.model.Commit;
import com.swissquote.crm.service.BranchService;

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
}
