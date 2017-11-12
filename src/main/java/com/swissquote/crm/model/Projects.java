package com.swissquote.crm.model;

import java.util.ArrayList;
import java.util.List;

public class Projects {
    private List<Project> projects = new ArrayList<>();

    public Projects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Projects projects1 = (Projects) o;

        return projects != null ? projects.equals(projects1.projects) : projects1.projects == null;
    }

    @Override
    public int hashCode() {
        return projects != null ? projects.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projects=" + projects +
                '}';
    }
}

