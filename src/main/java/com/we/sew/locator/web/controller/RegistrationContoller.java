package com.we.sew.locator.web.controller;

import com.we.sew.locator.web.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.REGISTER)
public class RegistrationContoller extends AbstractAppController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return WebUtil.View.REGISTER;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView register() {
        ModelAndView registerModel = createMaV();

        return registerModel;
    }
}
