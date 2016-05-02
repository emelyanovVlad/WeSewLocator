package com.we.sew.locator.admin.service.app;

import com.we.sew.locator.bean.FeedbackBean;
import com.we.sew.locator.db.entity.Feedback;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.FeedbackRepository;
import com.we.sew.locator.admin.service.app.api.AbstractService;
import com.we.sew.locator.admin.service.app.api.IFeedbackService;
import com.we.sew.locator.admin.util.IdGeneratorUtil;
import com.we.sew.locator.admin.util.adapter.FeedbackAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class FeedbackService extends AbstractService implements IFeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackAdapter feedbackAdapter;

    @Override
    public void create(FeedbackBean el, SystemUser creator) {
        Feedback adaptedFeed = feedbackAdapter.adapt(el);
        adaptedFeed.setId(IdGeneratorUtil.uuId());
        creationUpdateInfoEntityFiller.fill(adaptedFeed, creator);
    }

    @Override
    public Feedback get(String id) {
        return feedbackRepository.getOne(id);
    }

    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public void update(Feedback el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
        feedbackRepository.saveAndFlush(el);
    }

    @Override
    public Feedback delete(String id) {
        Feedback deletedFeedback = get(id);
        feedbackRepository.delete(id);
        return deletedFeedback;
    }
}
