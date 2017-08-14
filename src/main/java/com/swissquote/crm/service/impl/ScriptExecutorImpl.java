package com.swissquote.crm.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swissquote.crm.service.ScriptExecutor;

@Service
@Transactional
public class ScriptExecutorImpl implements ScriptExecutor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptExecutorImpl.class);
	private static final String GET_OPENED_BRANCHES_SCRIPT_PATH = "./src/main/resources/scripts/getOpenedBranches.sh";
	private static final String GET_COMMITS_BY_OPEN_BRANCH = "./src/main/resources/scripts/getCommitsByOpenedBranch.sh";

	@Override
	public List<String> getOpenedBranches(String projectName) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder(GET_OPENED_BRANCHES_SCRIPT_PATH, projectName);
		Process process = processBuilder.start();
		process.waitFor();
		return new ArrayList<>(Arrays.asList(getOutput(process).split("\\r?\\n")));
	}

	@Override
	public Map<String, String> getCommitsOfOpenedBranches(String projectName) throws IOException, InterruptedException {
		List<String> openedBranches = getOpenedBranches(projectName);
		excludeDefaultAndDevBranches(openedBranches);
		Map<String, String> commitsByOpenedBranch = new HashMap<>();
		//  TODO replace by Java 8 map
		openedBranches.forEach(branchName -> {
			commitsByOpenedBranch.put(branchName, getCommits(projectName, branchName));
		});
		return commitsByOpenedBranch;
	}

	private String getCommits(String projectName, String branchName) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(GET_COMMITS_BY_OPEN_BRANCH, projectName, branchName);
			Process process = processBuilder.start();
			process.waitFor();
			return getOutput(process);
		}
		catch (IOException | InterruptedException e) {
			LOGGER.error("Error during retrieving commits by project: {}, branch: {}", projectName, branchName, e);
			throw new RuntimeException(e);
		}
	}

	private void excludeDefaultAndDevBranches(List<String> branches) {
		branches.removeIf(branch -> branch.equals("default") || branch.equals("dev"));
	}

	private static String getOutput(Process p) throws IOException {
		return IOUtils.toString(p.getInputStream(), Charsets.UTF_8);
	}
}
