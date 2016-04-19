package com.we.sew.locator.service.app.api;

import com.we.sew.locator.db.entity.Question;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
public interface IQuestionService extends GenericService<Question, Integer> {
    Question getByHeader(String header);

    List<Question> getAllByHeader(String header);

}
