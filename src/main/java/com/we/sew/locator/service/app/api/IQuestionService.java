package com.we.sew.locator.service.app.api;

import com.we.sew.locator.bean.QuestionBean;
import com.we.sew.locator.db.entity.Question;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface IQuestionService extends GenericService<Question, QuestionBean, Integer> {
    Question getByHeader(String header);

    List<Question> getAllByHeader(String header);

}
