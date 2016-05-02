package com.we.sew.locator.admin.service.app;

import com.we.sew.locator.admin.bean.AnswerBean;
import com.we.sew.locator.admin.db.entity.Answer;
import com.we.sew.locator.admin.db.entity.SystemUser;
import com.we.sew.locator.admin.db.repository.AnswerRepository;
import com.we.sew.locator.admin.service.app.api.AbstractService;
import com.we.sew.locator.admin.service.app.api.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class AnswerService extends AbstractService implements IAnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void create(AnswerBean el, SystemUser creator) {
        Answer answer = new Answer();
        answer.setBody(el.getBody());
        creationUpdateInfoEntityFiller.fill(answer, creator);
        answerRepository.save(answer);
    }

    @Override
    public Answer get(Integer id) {
        return answerRepository.getOne(id);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public void update(Answer el, SystemUser updater) {
        editionUpdateInfoEntityFiller.fill(el, updater);
    }

    @Override
    public Answer delete(Integer id) {
        Answer deletedAnswer = get(id);
        answerRepository.delete(id);
        return deletedAnswer;
    }
}
