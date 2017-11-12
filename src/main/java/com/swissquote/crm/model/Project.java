package com.swissquote.crm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private List<Branch> branches = new ArrayList<>();

    public Project(String name, List<Branch> branches) {
        this.name = name;
        this.branches = branches;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
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
                Objects.equals(branches, project.branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, branches);
    }
}
