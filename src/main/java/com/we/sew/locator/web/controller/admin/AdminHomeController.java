package com.we.sew.locator.web.controller.admin;

import com.we.sew.locator.web.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(name = WebUtil.Mapping.HOME)
public class AdminHomeController extends AdminController {

    public ModelAndView getPage() {
        ModelAndView homeModel = createMaV(WebUtil.View.ADMIN_HOME);

        return homeModel;
    }
}
