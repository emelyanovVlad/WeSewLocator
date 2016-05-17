package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import com.we.sew.locator.db.entity.Category;
import com.we.sew.locator.admin.service.api.ICategoryService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class BranchAdapter implements EntityAdapter<Branch, BranchBean> {
    @Autowired
    private ICategoryService categoryService;

    @Override
    public Branch adapt(BranchBean el) {
        Branch branch = new Branch();
        Category category = categoryService.getBy(el.getCategoryName());
        branch.setName(el.getName());
        branch.setCategory(category);
        return branch;
    }
}
