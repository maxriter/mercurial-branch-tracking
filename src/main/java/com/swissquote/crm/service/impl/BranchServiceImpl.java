package com.swissquote.crm.service.impl;

import com.swissquote.crm.enumeration.CommitProperties;
import com.swissquote.crm.model.Commit;
import com.swissquote.crm.service.BranchService;
import com.swissquote.crm.service.ScriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    private static final String COLON = ":";
    private static final String VERTICAL_BAR = "|";

    @Autowired
    private ScriptExecutor scriptExecutor;

    @Override
    public List<String> getOpenedBranches(String projectName) throws IOException, InterruptedException {
        return scriptExecutor.getOpenedBranches(projectName);
    }

    @Override
    public Map<String, List<Commit>> getCommitsOfOpenedBranches(String projectName) throws IOException, InterruptedException {
        return scriptExecutor.getCommitsOfOpenedBranches(projectName).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, commitsAsString -> parseCommits(commitsAsString.getValue())));
    }

    private List<Commit> parseCommits(String response) {
        List<Commit> parsedCommits = new ArrayList<>();
        Arrays.asList(response.split("(?=" + CommitProperties.CHANGESET + ")")).forEach(commitToConvert -> {
            List<String> splittedCommit = splitCommitByAllAvailableProperties(commitToConvert);
            List<String> filteredCommitProperties =
                    filterCommitsByProperty(splittedCommit, Arrays.asList(CommitProperties.PARENT.toString(), CommitProperties.TAG.toString()));
            Commit commit = getCommitByProperties(filteredCommitProperties);
            parsedCommits.add(commit);
        });
        return parsedCommits;
    }

    private String getPropertyByName(List<String> commitProperties, String propertyName) {
        return commitProperties.stream().filter(property -> property.contains(propertyName)).findFirst().orElse("")
                .replace(propertyName + COLON, "").trim();
    }

    private List<String> filterCommitsByProperty(List<String> commits, List<String> propertiesToFilter) {
        return commits.stream().filter(commit -> !doesCommitContainProperties(commit, propertiesToFilter)).collect(Collectors.toList());
    }

    private Commit getCommitByProperties(List<String> commitProperties) {
        Commit commit = new Commit();
        commit.setChangeset(getPropertyByName(commitProperties, CommitProperties.CHANGESET.toString()));
        commit.setBranch(getPropertyByName(commitProperties, CommitProperties.BRANCH.toString()));
        commit.setUser((getPropertyByName(commitProperties, CommitProperties.USER.toString())));
        commit.setDate(getPropertyByName(commitProperties, CommitProperties.DATE.toString()));
        commit.setSummary(getPropertyByName(commitProperties, CommitProperties.SUMMARY.toString()));
        return commit;
    }

    private boolean doesCommitContainProperties(String commit, List<String> properties) {
        return properties.stream().anyMatch(commit::contains);
    }

    private List<String> splitCommitByAllAvailableProperties(String commit) {
        String regex = Stream.of(CommitProperties.values()).map(property -> "(?=" + property + ")").collect(Collectors.joining(VERTICAL_BAR));
        return Arrays.asList(commit.split(regex));
    }
}
