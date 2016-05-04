package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.web.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.HOME)
public class HomeController extends AbstractAppController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView homeModel = createMaV(WebUtil.View.HOME);

        return homeModel;
    }
}
