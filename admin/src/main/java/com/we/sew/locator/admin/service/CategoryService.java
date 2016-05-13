package com.we.sew.locator.admin.service;

import com.we.sew.locator.bean.CategoryBean;
import com.we.sew.locator.db.entity.Category;
import com.we.sew.locator.db.entity.SystemUser;
import com.we.sew.locator.db.repository.CategoryRepository;
import com.we.sew.locator.admin.service.api.AbstractService;
import com.we.sew.locator.admin.service.api.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class CategoryService extends AbstractService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getBy(String name) {
        return categoryRepository.findOneByName(name);
    }

    @Override
    public List<Category> getAllBy(String name) {
        return categoryRepository.findByNameContaining(name);
    }

    @Override
    public void create(CategoryBean el, SystemUser creator) {
        Category category = new Category();
        category.setName(el.getName());

        creationUpdaterInfoEntityFiller.fill(category, creator);
        categoryRepository.save(category);
    }

    @Override
    public Category get(Integer id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void update(Category el, SystemUser updater) {
        editionUpdaterInfoEntityFiller.fill(el, updater);

        categoryRepository.saveAndFlush(el);
    }

    @Override
    public Category delete(Integer id) {
        Category deletedCategory = get(id);
        categoryRepository.delete(id);
        return deletedCategory;
    }
}
