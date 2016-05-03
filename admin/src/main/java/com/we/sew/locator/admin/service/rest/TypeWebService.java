package com.we.sew.locator.admin.service.rest;

import com.we.sew.locator.db.entity.Category;
import com.we.sew.locator.db.repository.CategoryRepository;
import com.we.sew.locator.admin.service.rest.api.ITypeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class TypeWebService implements ITypeWebService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
