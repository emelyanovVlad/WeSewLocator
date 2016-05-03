package com.we.sew.locator.admin.util.adapter;

import com.we.sew.locator.admin.service.api.ICategoryService;
import com.we.sew.locator.admin.util.adapter.api.EntityAdapter;
import com.we.sew.locator.bean.ServiceBean;
import com.we.sew.locator.db.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class ServiceAdapter implements EntityAdapter<Service, ServiceBean> {
    @Autowired
    private ICategoryService categoryService;

    @Override
    public Service adapt(ServiceBean el) {
        Service service = new Service();
        service.setName(el.getName());
        service.setCategory(categoryService.getBy(el.getCategoryName()));
        return service;
    }
}
