package com.swissquote.crm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
	private String name;
	private Map<String, List<Commit>> commitsByOpenedBranch = new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, List<Commit>> getCommitsByOpenedBranch() {
		return commitsByOpenedBranch;
	}

	public void setCommitsByOpenedBranch(Map<String, List<Commit>> commitsByOpenedBranch) {
		this.commitsByOpenedBranch = commitsByOpenedBranch;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Project))
			return false;

		Project project = (Project) o;

		if (getName() != null ? !getName().equals(project.getName()) : project.getName() != null)
			return false;
		return getCommitsByOpenedBranch() != null ? getCommitsByOpenedBranch().equals(project.getCommitsByOpenedBranch()) :
				project.getCommitsByOpenedBranch() == null;
	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getCommitsByOpenedBranch() != null ? getCommitsByOpenedBranch().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Project{" +
				"name='" + name + '\'' +
				", commitsByOpenedBranch=" + commitsByOpenedBranch +
				'}';
	}
}
