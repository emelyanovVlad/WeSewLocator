package com.we.sew.locator.util.adapter;

import com.we.sew.locator.bean.QuestionBean;
import com.we.sew.locator.db.entity.Question;
import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.service.app.api.ITypeService;
import com.we.sew.locator.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class QuestionAdapter implements EntityAdapter<Question, QuestionBean> {
    @Autowired
    private ITypeService typeService;

    @Override
    public Question adapt(QuestionBean el) {
        Question question = new Question();
        question.setHeader(el.getHeader());
        question.setBody(el.getBody());
        Type type = typeService.getBy(el.getTypeName());
        question.setType(type);
        return question;
    }
}
