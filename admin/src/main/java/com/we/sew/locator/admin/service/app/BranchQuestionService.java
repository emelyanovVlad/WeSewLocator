package com.we.sew.locator.admin.service.app;

import com.we.sew.locator.db.entity.BranchQuestion;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.BranchQuestionRepository;
import com.we.sew.locator.admin.service.app.api.AbstractService;
import com.we.sew.locator.admin.service.app.api.IBranchQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class BranchQuestionService extends AbstractService implements IBranchQuestionService {
    @Autowired
    private BranchQuestionRepository branchQuestionRepository;

    @Override
    public void create(BranchQuestion el, SystemUser creator) {
        creationUpdateInfoEntityFiller.fill(el, creator);
        branchQuestionRepository.save(el);
    }

    @Override
    public BranchQuestion get(Long id) {
        return branchQuestionRepository.getOne(id);
    }

    @Override
    public List<BranchQuestion> getAll() {
        return branchQuestionRepository.findAll();
    }

    @Override
    public void update(BranchQuestion el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        branchQuestionRepository.save(el);
    }

    @Override
    public BranchQuestion delete(Long id) {
        BranchQuestion deletedBranchQuestion = get(id);
        branchQuestionRepository.delete(id);
        return deletedBranchQuestion;
    }
}
