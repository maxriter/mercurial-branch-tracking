package com.swissquote.crm.model;

import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private List<Branch> openedBranches;

    public Project(String name, List<Branch> openedBranches) {
        this.name = name;
        this.openedBranches = openedBranches;
    }

    public List<Branch> getOpenedBranches() {
        return openedBranches;
    }

    public void setOpenedBranches(List<Branch> openedBranches) {
        this.openedBranches = openedBranches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(openedBranches, project.openedBranches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, openedBranches);
    }
}
