package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.bean.RoleBean;
import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.admin.service.api.IRoleService;
import com.we.sew.locator.admin.web.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@Validated
@RequestMapping(value = WebUtil.Mapping.ROLES)
public class RoleController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Role> getAll() {
        return roleService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String createRole(@Valid RoleBean roleBean, HttpSession session) {

        roleService.create(roleBean, curUser(session));
        LOGGER.debug(roleBean.getName() + " created.");

        return roleBean.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public @ResponseBody String deleteRole(@RequestParam int roleId) {
        Role deletedRole = roleService.delete(roleId);
        LOGGER.warn(deletedRole.toString() + " was deleted.");
        return deletedRole.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public @ResponseBody
    List<Role> findByName(@RequestParam String name) {
        if (StringUtils.isBlank(name)) {
            return roleService.getAll();
        }
        return roleService.getAllBy(name);
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public @ResponseBody String editRole(@RequestParam int roleId, @Valid RoleBean roleBean, HttpSession session) {
        Role foundRole = roleService.get(roleId);
        foundRole.setName(roleBean.getName());
        roleService.update(foundRole, curUser(session));

        return foundRole + " role updated.";
    }

}
