package com.swissquote.crm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Transient
    private List<Commit> commits;

    @Transient
    private List<String> relatedProjects = new ArrayList<>();

    public Branch(String name, List<Commit> commits) {
        this.name = name;
        this.commits = commits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
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
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return Objects.equals(name, branch.name) &&
                Objects.equals(commits, branch.commits) &&
                Objects.equals(relatedProjects, branch.relatedProjects) &&
                Objects.equals(comment, branch.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, commits, relatedProjects, comment);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", commits=" + commits +
                ", relatedProjects=" + relatedProjects +
                ", comment='" + comment + '\'' +
                '}';
    }
}
