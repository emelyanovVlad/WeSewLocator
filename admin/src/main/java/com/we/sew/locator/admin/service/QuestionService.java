package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.QuestionBean;
import com.we.sew.locator.db.entity.Question;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.QuestionRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.IQuestionService;
import com.we.sew.locator.admin.util.adapter.QuestionAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class QuestionService extends AbstractService implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionAdapter questionAdapter;

    @Override
    public Question getByHeader(String header) {
        return questionRepository.findOneByHeader(header);
    }

    @Override
    public List<Question> getAllByHeader(String header) {
        return questionRepository.findByHeaderContaining(header);
    }

    @Override
    public void create(QuestionBean el, SystemUser creator) {
        Question adaptedQuestion = questionAdapter.adapt(el);
        creationUpdaterInfoEntityFiller.fill(adaptedQuestion, creator);
        questionRepository.save(adaptedQuestion);
    }

    @Override
    public Question get(Integer id) {
        return questionRepository.getOne(id);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void update(Question el, SystemUser updater) {
        editionUpdaterInfoEntityFiller.fill(el, updater);
    }

    @Override
    public Question delete(Integer id) {
        Question deletedQuestion = get(id);
        questionRepository.delete(id);
        return deletedQuestion;
    }
}
