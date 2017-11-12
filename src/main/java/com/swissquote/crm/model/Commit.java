package com.swissquote.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "commit")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Commit() {
    }

    @Column(name = "changeset")
    private String changeset;

    @Column(name = "branch")
    private String branch;

    @Column(name = "user")
    private String user;

    @Column(name = "date")
    private String date;

    @Column(name = "summary")
    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChangeset() {
        return changeset;
    }

    public void setChangeset(String changeset) {
        this.changeset = changeset;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Commit))
            return false;

        Commit commit = (Commit) o;

        if (getId() != null ? !getId().equals(commit.getId()) : commit.getId() != null)
            return false;
        if (getChangeset() != null ? !getChangeset().equals(commit.getChangeset()) : commit.getChangeset() != null)
            return false;
        if (getBranch() != null ? !getBranch().equals(commit.getBranch()) : commit.getBranch() != null)
            return false;
        if (getUser() != null ? !getUser().equals(commit.getUser()) : commit.getUser() != null)
            return false;
        if (getDate() != null ? !getDate().equals(commit.getDate()) : commit.getDate() != null)
            return false;
        return getSummary() != null ? getSummary().equals(commit.getSummary()) : commit.getSummary() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getChangeset() != null ? getChangeset().hashCode() : 0);
        result = 31 * result + (getBranch() != null ? getBranch().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getSummary() != null ? getSummary().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Commit{" + "id=" + id + ", changeset='" + changeset + '\'' + ", branch='" + branch + '\'' + ", user='" + user + '\'' + ", date='"
                + date + '\'' + ", summary='" + summary + '\'' + '}';
    }
}
