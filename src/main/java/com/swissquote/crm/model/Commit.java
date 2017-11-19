package com.swissquote.crm.model;

public class Commit {

    private String changeset;

    private String branch;

    private String user;

    private String date;

    private String summary;

    public Commit() {
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
        if (this == o) return true;
        if (!(o instanceof Commit)) return false;

        Commit commit = (Commit) o;

        if (changeset != null ? !changeset.equals(commit.changeset) : commit.changeset != null) return false;
        if (branch != null ? !branch.equals(commit.branch) : commit.branch != null) return false;
        if (user != null ? !user.equals(commit.user) : commit.user != null) return false;
        if (date != null ? !date.equals(commit.date) : commit.date != null) return false;
        return summary != null ? summary.equals(commit.summary) : commit.summary == null;
    }

    @Override
    public int hashCode() {
        int result = changeset != null ? changeset.hashCode() : 0;
        result = 31 * result + (branch != null ? branch.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        return result;
    }
}
