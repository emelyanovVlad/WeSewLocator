package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.bean.BranchBean;
import com.we.sew.locator.db.entity.Branch;
import com.we.sew.locator.db.entity.Type;
import com.we.sew.locator.admin.service.app.api.ITypeService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class BranchAdapter implements EntityAdapter<Branch, BranchBean> {
    @Autowired
    private ITypeService typeService;

    @Override
    public Branch adapt(BranchBean el) {
        Branch branch = new Branch();
        Type type = typeService.getBy(el.getTypeName());
        branch.setName(el.getName());
        branch.setType(type);
        return branch;
    }
}
