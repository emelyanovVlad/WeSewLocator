package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.admin.web.WebUtil;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Vladyslav_Yemelianov
 */
public abstract class AbstractAppController {

    protected ModelAndView createMaV(String viewName) {
        return new ModelAndView(viewName);
    }

    protected ModelAndView createMaV() {
        return new ModelAndView();
    }

    protected SystemUser curUser(HttpSession session) {
        return (SystemUser) session.getAttribute(WebUtil.Session.LOGGED_USER);
    }
}
