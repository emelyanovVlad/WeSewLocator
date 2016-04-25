package com.we.sew.locator.web.controller;

import org.springframework.web.servlet.ModelAndView;

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
}
