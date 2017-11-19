package com.swissquote.crm.service.impl;

import com.swissquote.crm.model.Branch;
import com.swissquote.crm.service.BranchService;
import com.swissquote.crm.service.CommitService;
import com.swissquote.crm.service.ScriptExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    private ScriptExecutorService scriptExecutorService;

    @Autowired
    private CommitService commitService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getListOfOpenedBranches(String projectName) {
        return scriptExecutorService.getOpenedBranches(projectName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Branch> getInfoByOpenedBranches(String projectName) {
        return scriptExecutorService.getCommitsOfOpenedBranches(projectName).entrySet().stream()
                .map(e -> new Branch(e.getKey(), commitService.parseCommits(e.getValue())))
                .collect(Collectors.toList());
    }

}
