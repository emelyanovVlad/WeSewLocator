package com.we.sew.locator.service.app;

import com.we.sew.locator.bean.QuestionBean;
import com.we.sew.locator.db.entity.Question;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.service.app.api.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class QuestionService implements IQuestionService {
    @Override
    public Question getByHeader(String header) {
        return null;
    }

    @Override
    public List<Question> getAllByHeader(String header) {
        return null;
    }

    @Override
    public void create(QuestionBean el, SystemUser creator) {

    }

    @Override
    public Question get(Integer integer) {
        return null;
    }

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public void update(Question el, SystemUser updater) {

    }

    @Override
    public Question delete(Integer el) {
        return null;
    }
}
