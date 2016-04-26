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
public class HomeContoller extends AbstractAppController {

    @RequestMapping(value = {WebUtil.Mapping.ROOT, WebUtil.Mapping.HOME}, method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView homeModel = createMaV(WebUtil.View.HOME);

        return homeModel;
    }
}
