package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.bean.QuestionBean;
import com.we.sew.locator.db.entity.Question;
import com.we.sew.locator.admin.service.app.api.IQuestionService;
import com.we.sew.locator.admin.service.app.api.ITypeService;
import com.we.sew.locator.admin.web.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.QUESTIONS)
public class QuestionController extends AbstractAppController{
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private ITypeService typeService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Question> getAll() {
        return questionService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addQuestion(@Valid QuestionBean questionBean, HttpSession session) {
        questionService.create(questionBean, curUser(session));

        LOGGER.debug(questionBean.getHeader() + " was created.");
        return questionBean.getHeader();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public @ResponseBody String deleteQuestion(@RequestParam int questionId) {
        Question deletedQuestion = questionService.delete(questionId);

        LOGGER.warn(deletedQuestion.toString() + " was deleted.");
        return deletedQuestion.getHeader();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public @ResponseBody String updateQuestion(@RequestParam int questionId, @Valid QuestionBean questionBean, HttpSession session) {
        Question question = questionService.get(questionId);
        updateOldQuestion(question, questionBean);
        questionService.update(question, curUser(session));

        LOGGER.debug(question.toString() + " updated");
        return question.getHeader();
    }

    private void updateOldQuestion(Question question, QuestionBean questionBean) {
        question.setHeader(questionBean.getHeader());
        question.setBody(questionBean.getBody());
        question.setType(typeService.getBy(questionBean.getTypeName()));
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public @ResponseBody List<Question> findAllBy(@RequestParam String header) {
        if (StringUtils.isBlank(header)) {
            return questionService.getAll();
        }
        return questionService.getAllByHeader(header);
    }

    @RequestMapping(value = WebUtil.Mapping.QUESTION, method = RequestMethod.GET)
    public ModelAndView goToQuestion(@PathVariable int questionId) {
        Question question = questionService.get(questionId);

        ModelAndView questionModel = createMaV();

        return questionModel;
    }

}
