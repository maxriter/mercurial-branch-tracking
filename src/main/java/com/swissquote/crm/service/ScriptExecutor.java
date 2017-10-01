package com.swissquote.crm.service;

import java.util.List;
import java.util.Map;

public interface ScriptExecutor {

	List<String> getOpenedBranches(String projectName);

	Map<String, String> getCommitsOfOpenedBranches(String projectName);

	List<String> getProjectNames();

}
