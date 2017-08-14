package com.swissquote.crm.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ScriptExecutor {

	List<String> getOpenedBranches(String projectName) throws IOException, InterruptedException;

	Map<String, String> getCommitsOfOpenedBranches(String projectName) throws IOException, InterruptedException;

}
