package com.we.sew.locator.admin.service.app.api;

import com.we.sew.locator.admin.bean.QuestionBean;
import com.we.sew.locator.admin.db.entity.Question;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface IQuestionService extends GenericService<Question, QuestionBean, Integer> {
    Question getByHeader(String header);

    List<Question> getAllByHeader(String header);

}
