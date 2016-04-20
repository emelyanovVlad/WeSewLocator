package com.we.sew.locator.service.app;

import com.we.sew.locator.db.entity.QuestionAnswer;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.service.app.api.IQuestionAnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class QuestionAnswerService implements IQuestionAnswerService {
    @Override
    public void create(QuestionAnswer el, SystemUser creator) {

    }

    @Override
    public QuestionAnswer get(Long aLong) {
        return null;
    }

    @Override
    public List<QuestionAnswer> getAll() {
        return null;
    }

    @Override
    public void update(QuestionAnswer el, SystemUser updater) {

    }

    @Override
    public QuestionAnswer delete(Long el) {
        return null;
    }
}
