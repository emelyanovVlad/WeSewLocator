package com.we.sew.locator.admin.service;

import com.we.sew.locator.db.entity.QuestionAnswer;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.QuestionAnswerRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class QuestionAnswerService extends AbstractService implements IQuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    @Override
    public void create(QuestionAnswer el, SystemUser creator) {
        creationUpdaterInfoEntityFiller.fill(el, creator);
        questionAnswerRepository.save(el);
    }

    @Override
    public QuestionAnswer get(Long id) {
        return questionAnswerRepository.getOne(id);
    }

    @Override
    public List<QuestionAnswer> getAll() {
        return questionAnswerRepository.findAll();
    }

    @Override
    public void update(QuestionAnswer el, SystemUser updater) {
        editionUpdaterInfoEntityFiller.fill(el, updater);

    }

    @Override
    public QuestionAnswer delete(Long id) {
        QuestionAnswer deletedQuestionAnswer = get(id);
        questionAnswerRepository.delete(id);
        return deletedQuestionAnswer;
    }
}
