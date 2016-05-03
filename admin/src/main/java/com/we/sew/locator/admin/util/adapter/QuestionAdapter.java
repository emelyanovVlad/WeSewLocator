package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.bean.QuestionBean;
import com.we.sew.locator.db.entity.Category;
import com.we.sew.locator.db.entity.Question;
import com.we.sew.locator.admin.service.app.api.ICategoryService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class QuestionAdapter implements EntityAdapter<Question, QuestionBean> {
    @Autowired
    private ICategoryService categoryService;

    @Override
    public Question adapt(QuestionBean el) {
        Question question = new Question();
        question.setHeader(el.getHeader());
        question.setBody(el.getBody());
        Category category = categoryService.getBy(el.getTypeName());
        question.setCategory(category);
        return question;
    }
}
