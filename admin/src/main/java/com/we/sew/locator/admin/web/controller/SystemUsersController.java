package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.bean.AdminSystemUserBean;
import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.admin.service.api.IRoleService;
import com.we.sew.locator.admin.service.api.ISystemUserService;
import com.we.sew.locator.admin.util.adapter.date.DateStringToIntegerAdapter;
import com.we.sew.locator.admin.web.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@Validated
@PreAuthorize(value = "hasRole('HEADADMIN')")
@RequestMapping(value = WebUtil.Mapping.USERS)
public class SystemUsersController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUsersController.class);

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
    public @ResponseBody String addSystemUser(@Valid @RequestBody AdminSystemUserBean userBean, HttpSession session) {
        userService.create(userBean, curUser(session));
        LOGGER.debug(userBean.getEmail() + " created with role " + userBean.getRoleName());
        return userBean.getEmail();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public String deleteUser(@RequestParam String userId) {
        SystemUser deletedUser = userService.delete(userId);
        LOGGER.warn(deletedUser.getEmail() + " was deleted.");
        return deletedUser.getEmail();
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
        return systemUser.getEmail();
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
