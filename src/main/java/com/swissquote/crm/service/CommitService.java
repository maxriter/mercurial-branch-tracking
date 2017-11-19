package com.swissquote.crm.service;

import com.swissquote.crm.model.Commit;

import java.util.List;

/**
 * Service for getting information by commits
 */
public interface CommitService {

    /**
     * Parse response of script executor service of retrieving commits
     *
     * @param commits commits as string
     * @return list of commits {@link Commit}
     */
    List<Commit> parseCommits(String commits);
}
