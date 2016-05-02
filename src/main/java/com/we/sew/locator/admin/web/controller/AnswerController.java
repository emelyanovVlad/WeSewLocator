package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.bean.AnswerBean;
import com.we.sew.locator.admin.db.entity.Answer;
import com.we.sew.locator.admin.service.app.api.IAnswerService;
import com.we.sew.locator.admin.web.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ADMIN + WebUtil.Mapping.ANSWERS)
public class AnswerController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerController.class);

    @Autowired
    private IAnswerService answerService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Answer> getAll() {
        return answerService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public
    @ResponseBody
    String addAnswer(@Valid AnswerBean answerBean, HttpSession session) {
        answerService.create(answerBean, curUser(session));

        LOGGER.debug(answerBean.getBody() + " added.");
        return answerBean.getBody();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteAnswer(@RequestParam int answerId) {
        Answer deletedAnswer = answerService.delete(answerId);

        LOGGER.warn(deletedAnswer.getBody() + " deleted.");
        return deletedAnswer.getBody();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public
    @ResponseBody
    String updateAnswer(@RequestParam int answerId, @Valid AnswerBean answerBean, HttpSession session) {
        Answer answer = answerService.get(answerId);
        answer.setBody(answerBean.getBody());
        answerService.update(answer, curUser(session));

        LOGGER.debug(answer.toString() + " updated.");
        return answer.getBody();
    }

    @RequestMapping(value = WebUtil.Mapping.ANSWER, method = RequestMethod.GET)
    public @ResponseBody Answer getAnswer(@PathVariable int answerId) {
        return answerService.get(answerId);
    }

}
