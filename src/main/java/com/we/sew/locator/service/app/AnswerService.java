package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.AnswerBean;
import com.we.sew.locator.db.entity.Answer;
import com.we.sew.locator.db.repository.AnswerRepository;
import com.we.sew.locator.service.app.api.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void create(AnswerBean el) {

    }

    @Override
    public AnswerBean get(Integer integer) {
        return null;
    }

    @Override
    public List<AnswerBean> getAll() {
        return null;
    }

    @Override
    public void update(AnswerBean el) {

    }

    @Override
    public AnswerBean delete(Integer el) {
        return null;
    }
}
