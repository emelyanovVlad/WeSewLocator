package com.we.sew.locator.service.app;

import com.we.sew.locator.db.entity.BranchQuestion;
import com.we.sew.locator.service.app.api.IBranchQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class BranchQuestionService implements IBranchQuestionService {
    @Override
    public void create(BranchQuestion el) {

    }

    @Override
    public BranchQuestion get(Long aLong) {
        return null;
    }

    @Override
    public List<BranchQuestion> getAll() {
        return null;
    }

    @Override
    public void update(BranchQuestion el) {

    }

    @Override
    public BranchQuestion delete(Long el) {
        return null;
    }
}
