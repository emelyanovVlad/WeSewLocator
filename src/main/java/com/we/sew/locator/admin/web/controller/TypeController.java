package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.admin.bean.TypeBean;
import com.we.sew.locator.admin.db.entity.Type;
import com.we.sew.locator.admin.service.app.api.ITypeService;
import com.we.sew.locator.admin.web.WebUtil;
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
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebUtil.Mapping.ADMIN + WebUtil.Mapping.TYPE)
public class TypeController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeController.class);

    @Autowired
    private ITypeService typeService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Type> getAll() {
        return typeService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addType(@Valid TypeBean typeBean, HttpSession session) {
        typeService.create(typeBean, curUser(session));

        LOGGER.debug(typeBean.getName() + " created.");
        return typeBean.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public @ResponseBody String deleteType(@RequestParam int typeId) {
        Type deletedType = typeService.delete(typeId);

        LOGGER.warn(deletedType.toString() + " was deleted.");
        return deletedType.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public @ResponseBody String updateType(@RequestParam int typeId, @Valid TypeBean typeBean, HttpSession session) {
        Type type = typeService.get(typeId);
        type.setName(typeBean.getName());
        typeService.update(type, curUser(session));

        LOGGER.debug(type.toString() + " was updated.");
        return type.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public List<Type> findTypes(@RequestParam String typeName) {
        if (StringUtils.isBlank(typeName)) {
            return typeService.getAll();
        }
        return typeService.getAllBy(typeName);
    }
}
