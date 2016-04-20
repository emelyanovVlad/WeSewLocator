package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.BranchRepository;
import com.we.sew.locator.service.app.api.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class BranchService implements IBranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch getBy(String name) {
        return null;
    }

    @Override
    public List<Branch> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(BranchBean el, SystemUser creator) {

    }

    @Override
    public Branch get(Integer integer) {
        return null;
    }

    @Override
    public List<Branch> getAll() {
        return null;
    }

    @Override
    public void update(Branch el, SystemUser updater) {

    }

    @Override
    public Branch delete(Integer el) {
        return null;
    }
}
