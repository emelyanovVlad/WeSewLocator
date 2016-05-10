package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.web.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
public class SessionContoller extends AbstractAppController {

    @RequestMapping(value = WebUtil.Mapping.LOGIN, method = RequestMethod.GET)
    public String loginPage() {
        return WebUtil.View.LOGIN;
    }

    @RequestMapping(value = WebUtil.Mapping.LOGIN, method = RequestMethod.POST)
    public void doLogin(HttpSession session) {

    }

}
