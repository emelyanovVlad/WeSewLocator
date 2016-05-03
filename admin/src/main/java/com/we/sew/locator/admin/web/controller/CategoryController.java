package com.we.sew.locator.admin.web.controller;

import com.we.sew.locator.bean.CategoryBean;
import com.we.sew.locator.db.entity.Category;
import com.we.sew.locator.admin.service.api.ICategoryService;
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
@RequestMapping(value = WebUtil.Mapping.CATEGORY)
public class CategoryController extends AbstractAppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Category> getAll() {
        return categoryService.getAll();
    }

    @RequestMapping(value = WebUtil.Mapping.ADD, method = RequestMethod.POST)
    public @ResponseBody String addType(@Valid CategoryBean categoryBean, HttpSession session) {
        categoryService.create(categoryBean, curUser(session));

        LOGGER.debug(categoryBean.getName() + " created.");
        return categoryBean.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.DELETE, method = RequestMethod.POST)
    public @ResponseBody String deleteType(@RequestParam int typeId) {
        Category deletedCategory = categoryService.delete(typeId);

        LOGGER.warn(deletedCategory.toString() + " was deleted.");
        return deletedCategory.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.EDIT, method = RequestMethod.POST)
    public @ResponseBody String updateType(@RequestParam int typeId, @Valid CategoryBean categoryBean, HttpSession session) {
        Category category = categoryService.get(typeId);
        category.setName(categoryBean.getName());
        categoryService.update(category, curUser(session));

        LOGGER.debug(category.toString() + " was updated.");
        return category.getName();
    }

    @RequestMapping(value = WebUtil.Mapping.FIND, method = RequestMethod.GET)
    public List<Category> findTypes(@RequestParam String categoryName) {
        if (StringUtils.isBlank(categoryName)) {
            return categoryService.getAll();
        }
        return categoryService.getAllBy(categoryName);
    }
}
