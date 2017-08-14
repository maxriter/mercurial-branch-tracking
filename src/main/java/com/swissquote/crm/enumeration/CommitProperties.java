package com.swissquote.crm.enumeration;

public enum CommitProperties {

	CHANGESET("changeset"), BRANCH("branch"), PARENT("parent"), TAG("tag"), USER("user"), DATE("date"), SUMMARY("summary");

	private String property;

	CommitProperties(String property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return property;
	}
}

