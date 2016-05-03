package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.BranchRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IBranchService;
import com.we.sew.locator.admin.util.adapter.BranchAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class BranchService extends AbstractService implements IBranchService {
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private BranchAdapter branchAdapter;

    @Override
    public Branch getBy(String name) {
        return branchRepository.findOneByName(name);
    }

    @Override
    public List<Branch> getAllBy(String name) {
        return branchRepository.findByNameContaining(name);
    }

    @Override
    public void create(BranchBean el, SystemUser creator) {
        Branch adaptedBranch = branchAdapter.adapt(el);
        creationUpdateInfoEntityFiller.fill(adaptedBranch, creator);
        branchRepository.save(adaptedBranch);
    }

    @Override
    public Branch get(Integer id) {
        return branchRepository.getOne(id);
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public void update(Branch el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        branchRepository.save(el);
    }

    @Override
    public Branch delete(Integer id) {
        Branch deletedBranch = get(id);
        branchRepository.delete(id);
        return deletedBranch;
    }
}
