package com.we.sew.locator.web.controller.admin;

import com.we.sew.locator.bean.admin.AdminSystemUserBean;
import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.service.app.api.IRoleService;
import com.we.sew.locator.service.app.api.ISystemUserService;
import com.we.sew.locator.util.adapter.date.DateStringToIntegerAdapter;
import com.we.sew.locator.web.WebUtil;
import com.we.sew.locator.web.controller.AbstractAppController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ADMIN + WebUtil.Mapping.USERS)
public class SystemUsersController111 extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUsersController111.class);

    @Autowired
    private ISystemUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private DateStringToIntegerAdapter adapter;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<SystemUser> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addSystemUser(@Valid AdminSystemUserBean userBean, HttpSession session) {
        userService.create(userBean, curUser(session));
        LOGGER.debug(userBean.getEmail() + " created with role " + userBean.getRoleName());
        return "User created successfully";
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public String deleteUser(@RequestParam String userId) {
        SystemUser deletedUser = userService.delete(userId);
        LOGGER.warn(deletedUser.getEmail() + " was deleted.");
        return deletedUser.toString();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public String updateUser(@RequestParam String userId, @Valid AdminSystemUserBean userBean, HttpSession session) {
        SystemUser systemUser = userService.get(userId);
        if (systemUser == null) {
            return "No user found by id: " + userId ;
        }
        adaptEntity(systemUser, userBean);

        userService.update(systemUser, curUser(session));
        LOGGER.debug(systemUser.getEmail() + " was updated. ");
        return systemUser.getEmail() + " was updated.";
    }

    private void adaptEntity(SystemUser systemUser, AdminSystemUserBean userBean) {
        systemUser.setEmail(userBean.getEmail());
        systemUser.setFullName(userBean.getFullName());
        systemUser.setBirthDate(adapter.adapt(userBean.getBirthDate()));
        Role newRole = roleService.getBy(userBean.getRoleName());
        systemUser.setRole(newRole);
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public @ResponseBody List<SystemUser> findUsers(@RequestParam String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return userService.getAll();
        }
        return userService.getAllBy(fullName);
    }

}
