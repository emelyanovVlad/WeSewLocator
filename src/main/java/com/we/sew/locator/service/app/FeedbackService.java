package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.FeedbackBean;
import com.we.sew.locator.db.repository.FeedbackRepository;
import com.we.sew.locator.service.app.api.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void create(FeedbackBean el) {

    }

    @Override
    public FeedbackBean get(String s) {
        return null;
    }

    @Override
    public List<FeedbackBean> getAll() {
        return null;
    }

    @Override
    public void update(FeedbackBean el) {

    }

    @Override
    public FeedbackBean delete(String el) {
        return null;
    }
}
