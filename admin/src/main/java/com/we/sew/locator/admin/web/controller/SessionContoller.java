package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.service.SystemUserService;
import com.we.sew.locator.admin.web.WebUtil;
import com.we.sew.locator.db.entity.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
public class SessionContoller extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionContoller.class);

    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping(value = WebUtil.Mapping.LOGIN, method = RequestMethod.GET)
    public String loginPage() {
        return WebUtil.View.LOGIN;
    }

    @RequestMapping(value = WebUtil.Mapping.AUTH, method = RequestMethod.GET)
    public String saveUser(HttpSession session, Principal principal) {
        String authorizedUserName = principal.getName();
        SystemUser systemUser = systemUserService.getByEmail(authorizedUserName);

        session.setAttribute(WebUtil.Session.LOGGED_USER, systemUser);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(authorizedUserName + " logged in");
        }

        return WebUtil.redirectTo(WebUtil.Mapping.ROOT);
    }

}
