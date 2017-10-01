package com.swissquote.crm.model;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String name;
    private List<String> relatedProjects = new ArrayList<>();
    private String comment;
    // TODO: add last date commit
    // TODO: add count of commits

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRelatedProjects() {
        return relatedProjects;
    }

    public void setRelatedProjects(List<String> relatedProjects) {
        this.relatedProjects = relatedProjects;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Branch)) return false;

        Branch branch = (Branch) o;

        if (name != null ? !name.equals(branch.name) : branch.name != null) return false;
        if (relatedProjects != null ? !relatedProjects.equals(branch.relatedProjects) : branch.relatedProjects != null)
            return false;
        return comment != null ? comment.equals(branch.comment) : branch.comment == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relatedProjects != null ? relatedProjects.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
