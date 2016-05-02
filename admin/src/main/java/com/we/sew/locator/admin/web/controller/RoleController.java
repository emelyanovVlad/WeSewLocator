package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.bean.RoleBean;
import com.we.sew.locator.db.entity.Role;
import com.we.sew.locator.admin.service.app.api.IRoleService;
import com.we.sew.locator.admin.web.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ADMIN + WebUtil.Mapping.ROLE)
public class RoleController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView roleModel = createMaV(WebUtil.View.ADMIN_ROLE);
        roleModel.addObject(WebUtil.ViewEntities.MAIN_CONTAINER, roleService.getAll());
        return roleModel;
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public String createRole(@Valid RoleBean roleBean, HttpSession session) {

        roleService.create(roleBean, curUser(session));
        LOGGER.debug(roleBean.getName() + " created.");

        return WebUtil.redirectTo(WebUtil.Mapping.ADMIN + WebUtil.Mapping.ROLE);
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public String deleteRole(@RequestParam int roleId) {
        Role deletedRole = roleService.delete(roleId);
        LOGGER.warn(deletedRole.toString() + " was deleted.");
        return deletedRole.toString();
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
    public String editRole(@RequestParam int roleId, @RequestParam String roleName, HttpSession session) {
        Role foundedRole = roleService.get(roleId);
        foundedRole.setName(roleName);
        roleService.update(foundedRole, curUser(session));

        return "Role updated.";
    }

}
