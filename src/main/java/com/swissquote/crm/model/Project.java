package com.swissquote.crm.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Branch> openedBranches = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Branch> getOpenedBranches() {
        return openedBranches;
    }

    public void setOpenedBranches(List<Branch> openedBranches) {
        this.openedBranches = openedBranches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        return openedBranches != null ? openedBranches.equals(project.openedBranches) : project.openedBranches == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (openedBranches != null ? openedBranches.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", openedBranches=" + openedBranches +
                '}';
    }
}
