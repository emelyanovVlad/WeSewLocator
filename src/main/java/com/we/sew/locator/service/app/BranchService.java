package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import com.we.sew.locator.service.app.api.IBranchService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class BranchService implements IBranchService {
    @Override
    public BranchBean getBy(String name) {
        return null;
    }

    @Override
    public List<BranchBean> getAllBy(String name) {
        return null;
    }

    @Override
    public void create(BranchBean el) {

    }

    @Override
    public BranchBean get(Integer integer) {
        return null;
    }

    @Override
    public List<BranchBean> getAll() {
        return null;
    }

    @Override
    public void update(BranchBean el) {

    }

    @Override
    public BranchBean delete(Integer el) {
        return null;
    }
}
